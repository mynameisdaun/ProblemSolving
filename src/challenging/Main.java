package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0], k = input[1], r = input[2];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        List<List<List<int[]>>> road = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            road.add(new ArrayList<>());
            for (int j = 0; j <= n; j++) {
                road.get(i).add(new ArrayList<>());
            }
        }

        for (int i = 0; i < r; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = input[0], y1 = input[1], x2 = input[2], y2 = input[3];
            road.get(x1).get(y1).add(new int[]{x2, y2});
            road.get(x2).get(y2).add(new int[]{x1, y1});
        }

        int[][] board = new int[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            board[input[0]][input[1]] = 1;
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i][j] == 1) {
                    boolean[][] visited = new boolean[n + 1][n + 1];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    int cow = 0;
                    while (!queue.isEmpty()) {
                        int[] node = queue.poll();
                        int x = node[0];
                        int y = node[1];
                        if (board[x][y] == 1) {
                            cow++;
                        }
                        for (int l = 0; l < 4; l++) {
                            int nx = x+dx[l];
                            int ny = y+dy[l];
                            if(nx>=1&&nx<=n&&ny>=1&&ny<=n&&!visited[nx][ny]&&noBridge(x,y,nx,ny,road)) {
                                visited[nx][ny]=true;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    answer += (k - cow);
                }
            }
        }
        System.out.println(answer / 2);
    }
    public static boolean noBridge(int x1, int y1, int x2, int y2, List<List<List<int[]>>> road) {
        if(road.get(x1).get(y1).isEmpty()) {
            return true;
        } else {
            return road.get(x1).get(y1).stream()
                    .filter( r ->r[0]==x2&&r[1]==y2).count() == 0;
        }
    }
    /*
    0 0 0

    0 0 0
      | |
    0 0-0
     */
}

