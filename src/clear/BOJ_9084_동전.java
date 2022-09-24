package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class BOJ_9084_동전 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());

        while (T-- > 0) {
            int n = parseInt(br.readLine());
            int[] coins = new int[n];
            StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                coins[i] = parseInt(tokens.nextToken());
            }

            int target = parseInt(br.readLine());
            int[] dp = new int[target + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int j = coin; j <= target; j++) {
                    dp[j]+=dp[j-coin];
                }
            }
            System.out.println(dp[target]);
        }
    }
}

