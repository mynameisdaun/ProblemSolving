package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_돌다리건너기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] steps = new int[]{1,2};
        int[] dp = new int[N+2];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        if(N<=2) {
            System.out.println(dp[N]);
            return;
        }
        for(int i = 3 ; i <= N+1 ; i++) {
            dp[i] = dp[i-2]+dp[i-1];
        }
        System.out.println(dp[N+1]);
    }
}
