//package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int[] stairs;
    static int[] dp;
    static int n;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stairs = new int[n+1];
        dp = new int[n+1];

        for(int i = 1 ; i <= n ; i ++) {
            stairs[i]= Integer.parseInt(br.readLine());
        }

        if(n==1) {
            System.out.println(stairs[1]);
            return;
        }

        dp[0] = 0;
        dp[1] = stairs[1];
        dp[2] = stairs[1]+stairs[2];
        for(int i = 3 ; i <= n ; i ++) {
            dp[i] = stairs[i] + Math.max(stairs[i-1]+dp[i-3], dp[i-2]);
            //System.out.println(dp[i]);
        }
        System.out.println(dp[n]);
    }
}