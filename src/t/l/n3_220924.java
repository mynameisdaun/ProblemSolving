package t.l;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class n3_220924 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
//        int n = 5;
//        int m = 3;
//        int[][] fires = {{5, 5}, {1, 3}, {5, 2}};
//        int[][] ices = {{1, 5}, {3, 2}};
          int n = 5;
          int m = 1000000;
          int[][] fires = {{1, 1}};
          int[][] ices = {};

        long[][] solution1 = solution.solution(n, m, fires, ices);
        for (int i = 0; i < solution1.length; i++) {
            for (int j = 0; j < solution1[0].length; j++) {
                System.out.print(solution1[i][j] + " ");
            }
            System.out.println();
        }

    }

    static class Solution {
        public long[][] solution(int n, int m, int[][] fires, int[][] ices) {
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            long[][] board = new long[n][n];

            int t = 1;
            int[][] effect = new int[n][n];

            while (true) {
                //fire 처리
                for (int f = 0; f < fires.length; f++) {
                    int[] fire = fires[f];
                    int x = fire[0] - 1;
                    int y = fire[1] - 1;
                    for (int i = x - t; i <= x + t; i++) {
                        for (int j = y - t; j <= y + t; j++) {
                            if (i >= 0 && i < n && j >= 0 && j < n) {
                                board[i][j]++;
                                if (t == 30) {
                                    effect[i][j]++;
                                }
                            }
                        }
                    }
                }

                for (int c = 0; c < ices.length; c++) {
                    boolean[][] visited = new boolean[n][n];

                    int[] ice = ices[c];
                    int x = ice[0] - 1;
                    int y = ice[1] - 1;

                    Queue<int[]> queue = new LinkedList<>();
                    visited[x][y] = true;
                    board[x][y]--;
                    queue.offer(new int[]{x, y, 0});

                    while (!queue.isEmpty()) {
                        int[] node = queue.poll();

                        if (node[2] >= t) break;

                        for (int i = 0; i < 4; i++) {
                            int nx = node[0] + dx[i];
                            int ny = node[1] + dy[i];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                board[nx][ny]--;
                                queue.offer(new int[]{nx, ny, node[2] + 1});
                                if (t == 30) {
                                    effect[nx][ny]--;
                                }
                            }
                        }
                    }
                }

                if (++t > m || t >= 31) break;
            }

            if (m >= 31) {
                long cnt = m - 30;
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[0].length; j++) {
                        board[i][j] += cnt * effect[i][j];
                    }
                }
            }
            return board;
        }
    }
}

