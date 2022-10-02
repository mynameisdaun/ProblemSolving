package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17142_연구소3 {

    static int n, m, target = 0, answer = Integer.MAX_VALUE;
    static List<int[]> viruses = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
                if (board[i][j] == 2) viruses.add(new int[]{i, j});
                if (board[i][j] == 0) target++;
            }
        }
        dfs(0,0,new int[m], board);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void dfs(int L, int s, int[] cb, int[][] board) {
        if (L == m) {
            bfs(cb, copy(board));
            return;
        }
        for (int i = s; i < viruses.size(); i++) {
            cb[L] = i;
            dfs(L + 1, i+1, cb, board);
        }
    }

    static void bfs(int[] cb, int[][] copy) {
        Queue<int[]> queue = new LinkedList<>();

        int cnt = 0;
        for (int i = 0; i < cb.length; i++) {
            int[] node = viruses.get(cb[i]);
            copy[node[0]][node[1]] = 1;
            queue.offer(new int[]{node[0], node[1], 0});
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            if(cnt>=target) {
                answer = Math.min(answer, node[2]);
                return;
            }
            if (node[2] >= answer) return;

            int x = node[0];
            int y = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && copy[nx][ny] != 1) {
                    if(copy[nx][ny]==0) cnt++;
                    copy[nx][ny] = 1;
                    queue.offer(new int[]{nx, ny, node[2] + 1});
                    if (cnt >= target) {
                        answer = Math.min(answer, node[2] + 1);
                        return;
                    }
                }
            }
        }
    }

    static int[][] copy(int[][] board) {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j]=board[i][j];
            }
        }
        return copy;
    }
}
