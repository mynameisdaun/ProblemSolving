package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.Integer.parseInt;

public class BOJ_16234_인구이동 {

    static int N, L, R, board[][], dx[], dy[];
    static boolean visited[][], find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        dx = new int[]{0, 1, 0, -1};
        dy = new int[]{1, 0, -1, 0};
        N = parseInt(input[0]);
        L = parseInt(input[1]);
        R = parseInt(input[2]);
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = parseInt(input[j]);
            }
        }
        int answer = 0;
        while (move()) {
            answer++;
        }
        System.out.println(answer);
    }

    static boolean move() {
        visited = new boolean[N][N];
        find = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        return find;
    }

    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> memo = new ArrayList<>();

        visited[i][j] = true;
        int sum = 0;
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && Math.abs(board[nx][ny] - board[x][y]) >= L && Math.abs(board[nx][ny] - board[x][y]) <= R) {
                    int[] next = new int[]{nx, ny};
                    sum += board[nx][ny];
                    memo.add(next);

                    visited[nx][ny] = true;
                    queue.offer(next);
                }
            }
        }
        if (!memo.isEmpty()) {
            sum += board[i][j];
            memo.add(new int[]{i, j});
            int dividened = Math.floorDiv(sum, memo.size());
            for (int m = 0; m < memo.size(); m++) {
                int[] curr = memo.get(m);
                board[curr[0]][curr[1]] = dividened;
            }
            find = true;
        }
    }
}


