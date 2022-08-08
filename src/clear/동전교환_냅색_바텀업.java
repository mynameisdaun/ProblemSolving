package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 동전교환_냅색_바텀업 {
    //knapsack 알고리즘
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] coins = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).
                        toArray();
        Arrays.sort(coins);
        int money = Integer.parseInt(br.readLine());
        int[] dp = new int[money + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        System.out.println(dp[money]);
    }
}
//n의 개수가 많아서, DFS로는 풀수 없었다는 사실을 인지한다. bottom -> up 방식임을 안다
