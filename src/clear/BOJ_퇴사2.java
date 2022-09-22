package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_퇴사2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] schedule = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
            schedule[i + 1][0] = Integer.parseInt(tokens.nextToken());
            schedule[i + 1][1] = Integer.parseInt(tokens.nextToken());
        }

        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = n; i >= 1; i--) {
            int time = schedule[i][0] + i - 1;
            if (time > n) {
                dp[i] = max;
            } else {
                dp[i] = Math.max(max, (time == n ? 0 : dp[time + 1]) + schedule[i][1]);
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
