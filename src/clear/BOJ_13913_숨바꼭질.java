package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_13913_숨바꼭질 {

    static int INF = 100001;
    static boolean find = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[INF + 1];
        Arrays.fill(dp, INF);

        dp[arr[0]] = 0;
        bfs(arr[0], arr[1], dp);

        System.out.println(dp[arr[1]]);
        int[] route = new int[dp[arr[1]] + 1];
        route[0] = arr[0];
        dfs(route, 1, arr[0], arr[1], dp);
    }

    public static void dfs(int[] route, int L, int now, int end, int[] dp) {
        if (find) return;
        if (L == route.length) {
            if (now == end) {
                find = true;
                for (int i = 0; i < route.length; i++) {
                    System.out.print(route[i] + " ");
                }
                System.out.println();
            }
        } else {
            if (now * 2 < INF && dp[now * 2] == dp[now] + 1) {
                route[L] = now * 2;
                dfs(route, L + 1, now * 2, end, dp);
            }
            if (now - 1 >= 0 && dp[now - 1] == dp[now] + 1) {
                route[L] = now - 1;
                dfs(route, L + 1, now - 1, end, dp);
            }
            if (now + 1 < INF && dp[now + 1] == dp[now] + 1) {
                route[L] = now + 1;
                dfs(route, L + 1, now + 1, end, dp);
            }
        }
    }

    public static void bfs(int start, int end, int[] dp) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {

            Integer now = queue.poll();

            if (now == end) return;

            if (now * 2 < INF && dp[now * 2] == INF) {
                dp[now * 2] = dp[now] + 1;
                queue.offer(now * 2);
            }
            if (now + 1 < INF && dp[now + 1] == INF) {
                dp[now + 1] = dp[now] + 1;
                queue.offer(now + 1);
            }
            if (now - 1 >= 0 && dp[now - 1] == INF) {
                dp[now - 1] = dp[now] + 1;
                queue.offer(now - 1);
            }
        }
    }
}
