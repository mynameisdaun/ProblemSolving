package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2156_포도주시식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] juice = new int[n+1];
        for (int i = 1 ; i <= n; i++) {
            juice[i] = Integer.parseInt(br.readLine());
        }

        if (n <= 2) {
            System.out.println(Arrays.stream(juice).sum());
            return;
        }
        int[] dp = new int[n+1];
        dp[1] = juice[1];
        dp[2] = juice[1]+juice[2];
        for(int i = 3; i <= n ; i++) {
            dp[i] = dp[i-1];//안먹는거
            dp[i] = Math.max(dp[i], dp[i-3]+juice[i-1]+juice[i]);
            dp[i] = Math.max(dp[i], dp[i-2]+juice[i]);
        }
        System.out.println(dp[n]);
    }
}


