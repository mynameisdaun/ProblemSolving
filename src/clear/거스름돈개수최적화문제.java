package clear;

import java.io.IOException;
import java.util.Arrays;

public class 거스름돈개수최적화문제 {

    public static void main(String[] args) throws IOException {
        int n = 3;
        int m  = 7;
        int[] arr = {2,3,5};

        int[] dp = new int[m+1];
        Arrays.fill(dp,9999);
        dp[0]=0;
        for(int i = 1 ; i < m+1 ; i ++) {
            for(int j = 0 ; j < arr.length ; j ++) {
                if(i - arr[j] >= 0) {
                    dp[i] = Math.min(dp[i-arr[j]]+1,dp[i]);
                }
            }
        }
    }
}
