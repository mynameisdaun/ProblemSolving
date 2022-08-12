package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_18353_병사_배치 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] soldiers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N];
        if(N==1) {
            System.out.println(0);
            return;
        }
        Arrays.fill(dp, 1);
        for(int i = 1 ; i < dp.length ; i++) {
            for(int j = i-1 ; j >= 0 ; j--) {
                if(soldiers[j] > soldiers[i]) {
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(N - dp[N-1]);
    }
}

