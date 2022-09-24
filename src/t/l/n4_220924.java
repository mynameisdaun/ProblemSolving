package t.l;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class n4_220924 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        String[] wall = {"....HH", "H..H.H"};
        int[][] solution1 = solution.solution(wall);
        for (int i = 0; i < solution1.length; i++) {
            for (int j = 0; j < solution1[0].length; j++) {
                System.out.print(solution1[i][j] + " ");
            }
            System.out.println();

        }
    }

    static class Solution {
        public int[][] solution(String[] wall) {
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};
            int row = wall.length;
            int col = wall[0].length();
            String[][] board = new String[row][col];
            int[][] answer = new int[row][col];
            boolean[][] visited = new boolean[row][col];

            for (int i = 0; i < wall.length; i++) {
                Arrays.fill(answer[i], -1);
                String[] input = wall[i].split("");
                for (int j = 0; j < col; j++) {
                    board[i][j] = input[j];
                    if (board[i][j].equals(".") || board[i][j].equals("X")) {
                        answer[i][j] = 0;
                    }
                }
            }

            //행, 열, 레벨

            Queue<int[]> queue = new LinkedList<>();
            int[] start = {row - 1, 0, 1};
            queue.offer(start);

            visited[row - 1][0] = true;
            answer[row - 1][0] = 1;

            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                int d = node[2];

                //4방향 탐험
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col && !visited[nx][ny] && board[nx][ny].equals("H")) {
                        queue.offer(new int[]{nx, ny, d + 1});
                        visited[nx][ny] = true;
                        answer[nx][ny] = d + 1;
                    }
                }

                //우측 위, 좌측 위
                if (x - 1 >= 0 && board[x - 1][y].equals(".")) {
                    for (int i = 0; i < 2; i++) {
                        int ny = y + dy[i];
                        if (ny >= 0 && ny < col && board[x][ny].equals(".") && !visited[x - 1][ny] && board[x - 1][ny].equals("H")) {
                            queue.offer(new int[]{x - 1, ny, d + 1});
                            visited[x - 1][ny] = true;
                            answer[x - 1][ny] = d + 1;
                        }
                    }
                }

                //위로 두칸
                if (x - 2 >= 0 && board[x - 1][y].equals(".") && !visited[x - 2][y] && board[x - 2][y].equals("H")) {
                    queue.offer(new int[]{x - 2, y, d + 1});
                    visited[x - 2][y] = true;
                    answer[x - 2][y] = d + 1;
                }

                //위칸이 비어있을때
                if (x - 1 >= 0 && board[x - 1][y].equals(".")) {
                    //좌우로 많이
                    for (int i = 0; i < 2; i++) {
                        for (int j = 1; j <= 2; j++) {
                            //움직이려는 칸이 홀드이고 위칸이 비어있어야함
                            boolean possible = true;
                            int ny = y + dy[i] * (j + 1);
                            if (ny >= 0 && ny < col && !visited[x][ny] && board[x - 1][ny].equals(".") && board[x][ny].equals("H")) {
                                for (int k = j; k >= 1; k--) {
                                    int nny = y + dy[i] * k;
                                    if (!board[x - 1][nny].equals(".") || !board[x][nny].equals(".")) {
                                        possible = false;
                                        break;
                                    }
                                }
                                if (possible) {
                                    queue.offer(new int[]{x, ny, d + 1});
                                    visited[x][ny] = true;
                                    answer[x][ny] = d + 1;
                                }
                            }
                        }
                    }
                }
            }
            return answer;
        }
    }
}

