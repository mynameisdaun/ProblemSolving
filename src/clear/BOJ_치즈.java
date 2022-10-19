package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_치즈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = input[0], col = input[1], cheeseCount = 0;
        int board[][] = new int[row][col], memo[] = new int[101];
        int dx[] = {1, 0, 0, -1}, dy[] = {0, -1, 1, 0};

        for (int i = 0; i < row; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < col; j++) {
                board[i][j] = input[j];
                if (board[i][j] == 1) cheeseCount++;
            }
        }
        for (int i = 0; i < row; i++) {
            board[i][0] = -1;
            board[i][col - 1] = -1;
        }
        for (int i = 0; i < col; i++) {
            board[0][i] = -1;
            board[row - 1][i] = -1;
        }
        List<List<int[]>> holes = new ArrayList<>();
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (board[i][j] == 0) {
                    boolean hole = true;
                    List<int[]> route = new ArrayList<>();
                    Queue<int[]> q = new LinkedList();
                    route.add(new int[]{i, j});
                    q.offer(new int[]{i, j});

                    boolean[][] visited = new boolean[row][col];
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] node = q.poll();
                        int x = node[0];
                        int y = node[1];
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (board[nx][ny] == -1) {
                                hole = false;
                                break;
                            }
                            if (!visited[nx][ny] && board[nx][ny] == 0) {
                                visited[nx][ny] = true;
                                route.add(new int[]{nx, ny});
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    if (hole) {
                        route.forEach(r -> board[r[0]][r[1]] = 3);
                        holes.add(route);
                        continue;
                    }
                    route.forEach(r -> board[r[0]][r[1]] = -1);
                }
            }
        }
        Queue<int[]> border = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 1) {
                    boolean isBorder = false;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (board[nx][ny] == -1) {
                            board[i][j] = 2;
                            isBorder = true;
                            break;
                        }
                    }
                    if (isBorder) {
                        border.add(new int[]{i, j, 0});
                    }
                }
            }
        }
        int time = -1;
        while (!border.isEmpty()) {
            int[] node = border.poll();
            int x = node[0];
            int y = node[1];
            int t = node[2];
            memo[t]++;
            if (t > time) {
                time = Math.max(t, time);
                for (List<int[]> hole : holes) {
                    boolean noMoreHole = false;
                    for (int[] pos : hole) {
                        for (int i = 0; i < 4; i++) {
                            int nx = pos[0] + dx[i];
                            int ny = pos[1] + dy[i];
                            if (board[nx][ny] == -1) {
                                noMoreHole = true;
                                break;
                            }
                        }
                        if (noMoreHole) break;
                    }
                    if (noMoreHole) {
                        hole.forEach(h -> {
                            board[h[0]][h[1]] = -1;
                            for (int i = 0; i < 4; i++) {
                                int nx = h[0] + dx[i];
                                int ny = h[1] + dy[i];
                                if (board[nx][ny] == 1) {
                                    board[nx][ny] = 2;
                                    border.offer(new int[]{nx, ny, t});
                                }
                            }
                        });
                    }
                }
                holes = holes.stream().filter(h -> {
                    int[] ints = h.get(0);
                    return board[ints[0]][ints[1]] == 3;
                }).collect(Collectors.toList());
            }
            board[x][y] = -1;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (board[nx][ny] == 1) {
                    board[nx][ny] = 2;
                    border.offer(new int[]{nx, ny, t + 1});
                }
            }
        }
        System.out.println(time + 1);
        for (int i = 0; i < time; i++) {
            cheeseCount -= memo[i];
        }
        System.out.println(cheeseCount);
    }
}

