package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1005_ACM_CRAFT {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcase = Integer.parseInt(br.readLine());

        while (tcase-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            boolean[][] board = new boolean[n + 1][n + 1];

            int[] time = new int[n + 1];
            int[] construct = new int[n + 1];
            boolean[] visited = new boolean[n + 1];

            input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                construct[i + 1] = Integer.parseInt(input[i]);
            }

            int[] degree = new int[n + 1];
            for (int i = 0; i < k; i++) {
                input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                board[start][end] = true;
                degree[end]++;
            }

            int target = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                if (degree[i] == 0) {
                    visited[i] = true;
                    time[i] = construct[i];
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                Integer now = queue.poll();

                for (int i = 1; i <= n; i++) {
                    if (board[now][i]) {
                        degree[i]--;
                        time[i] = Math.max(time[i], time[now] + construct[i]);
                        if(degree[i]==0 && !visited[i]) {
                            visited[i] = true;
                            queue.offer(i);
                        }
                    }
                }
            }
            System.out.println(time[target]);
        }
    }
}
