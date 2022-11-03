package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2245_합분해 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[][] dp = new int[k][n+1];
        for (int i = 0; i < k; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < n+1; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i < k ; i++) {
            for (int j = 1; j <= n ; j++) {
                dp[i][j] = (dp[i][j-1]+dp[i-1][j])%1000000000;
            }
        }
        System.out.println(dp[k-1][n]);
    }
}
