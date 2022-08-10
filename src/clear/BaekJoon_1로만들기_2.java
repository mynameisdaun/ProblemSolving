package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_1로만들기_2 {
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1000000);
        dp[N] = 0;
        for (int i = N; i >= 1; i--) {
            if (i % 3 == 0) {
                dp[i / 3] = Math.min(dp[i] + 1, dp[i / 3]);
            }
            if (i % 2 == 0) {
                dp[i / 2] = Math.min(dp[i] + 1, dp[i / 2]);
            }
            dp[i - 1] = Math.min(dp[i] + 1, dp[i - 1]);
        }
        System.out.println(dp[1]);
        System.out.print(N+" ");
        int[] route = new int[dp[1]];
        DFS(N, 0, dp, route);
    }

    public static void DFS(int curr, int L, int[] dp, int[] route) {
        if (flag) return;
        if (curr == 1 && L == dp[1]) {
            flag = true;
            for (int i = 0; i < route.length; i++) {
                System.out.print(route[i] + " ");
            }
            System.out.println();
        } else {
            if(L>=dp[1]) return;
            if (curr % 3 == 0 && dp[curr / 3] == dp[curr] + 1) {
                route[L] = curr / 3;
                DFS(curr / 3, L + 1, dp, route);
            }
            if (curr % 2 == 0 && dp[curr / 2] == dp[curr] + 1) {
                route[L] = curr / 2;
                DFS(curr / 2, L + 1, dp, route);
            }
            if (dp[curr - 1] == dp[curr] + 1) {
                route[L] = curr - 1;
                DFS(curr - 1, L + 1, dp, route);
            }
        }
    }
}

