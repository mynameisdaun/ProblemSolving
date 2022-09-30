package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_상어초등학교 {
    static int n, nn, dx[], dy[], board[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nn = n * n;
        dx = new int[]{0, 0, 1, -1};
        dy = new int[]{1, -1, 0, 0};
        board = new int[n + 1][n + 1];
        int[][] memo = new int[nn + 1][2];
        List<int[]> command = new ArrayList<>();

        for (int i = 0; i < n * n; i++) {
            command.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int l = 0; l < command.size(); l++) {
            Set<Integer> set = new HashSet<>();
            int[] c = command.get(l);
            int student = c[0];
            int[][] check = new int[nn + 1][nn + 1];
            //cnt, 인접칸수, x, y;
            int max = 0;
            for (int i = 1; i <= 4; i++) {
                int friend = c[i];
                set.add(friend);
                int x = memo[friend][0];
                int y = memo[friend][1];
                if (x > 0 && y > 0) {
                    for (int j = 0; j < 4; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && board[nx][ny] == 0) {
                            check[nx][ny]++;
                        }
                    }
                }
            }
            int[] node = {-1, -1, -1, -1};
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (board[i][j] == 0) {
                        if (node[2] < check[i][j]) {
                            node[0] = i;
                            node[1] = j;
                            node[2] = check[i][j];
                            node[3] = countNear(i, j);
                        } else if (node[2] == check[i][j] && node[3] < countNear(i, j)) {
                            node[0] = i;
                            node[1] = j;
                            node[3] = countNear(i, j);
                        }
                    }
                }

            }
            board[node[0]][node[1]] = student;
            memo[student] = new int[]{node[0], node[1]};
            map.put(student, set);
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int student = board[i][j];
                Set<Integer> set = map.getOrDefault(student, new HashSet<>());
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && set.contains(board[nx][ny])) {
                        cnt++;
                    }
                }
                if (cnt > 0) {
                    answer += Math.pow(10, cnt - 1);
                }
            }
        }
        System.out.println(answer);
    }

    static int countNear(int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && board[nx][ny] == 0)
                count++;
        }
        return count;
    }
}

/*
3
4 1 2 3 5
3 1 2 4 5
9 1 2 3 4
8 1 2 3 4
7 1 2 3 4
1 2 3 4 5
6 1 2 3 4
5 1 2 3 4
2 1 3 4 5

3
4 1 2 3 5
3 1 2 4 5
9 1 2 3 4
8 3 4 7 9
7 1 2 3 4
1 2 3 4 5
6 1 2 3 4
5 1 2 3 4
2 1 3 4 5
 */


/*
9 3 2
8 4 7
5 6 1

3
2 6 9 3 4
9 4 5 1 2
3 9 2 1 4
7 8 1 4 6
5 7 3 9 4
1 7 6 8 3
6 9 3 4 5
4 9 7 5 2
8 1 5 3 6
 */

/*
3
4 1 2 3 5
3 1 2 4 5
9 1 2 3 4
8 1 2 3 4
7 1 2 3 4
1 2 3 4 5
6 1 2 3 4
5 1 2 3 4
2 1 3 4 5

3
4 1 2 3 5
3 1 2 4 5
9 1 2 3 4
8 3 4 7 9
7 1 2 3 4
1 2 3 4 5
6 1 2 3 4
5 1 2 3 4
2 1 3 4 5

4
4 1 2 3 5
9 11 10 12 13
3 6 7 8 10
5 7 4 16 12
12 1 2 3 6
8 3 4 7 9
7 1 2 3 4
1 2 3 4 5
6 1 2 3 4
2 1 3 4 5
10 2 3 4 5
11 1 2 3 4
13 1 3 4 5
14 1 3 4 5
15 1 3 4 5
16 1 3 4 5
 */


/*
9 3 2
8 4 7
5 6 1

3
2 6 9 3 4
9 4 5 1 2
3 9 2 1 4
7 8 1 4 6
5 7 3 9 4
1 7 6 8 3
6 9 3 4 5
4 9 7 5 2
8 1 5 3 6

3
1 2 3 4 5
2 3 4 5 6
3 4 5 6 7
4 5 6 7 8
5 6 7 8 9
6 7 8 9 1
7 8 9 1 2
8 9 1 2 3
9 1 2 3 4







 */
