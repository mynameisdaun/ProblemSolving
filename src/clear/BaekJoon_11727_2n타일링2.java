package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_11727_2n타일링2 {

    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n+1];


        if(n==1){
            System.out.println(1);
            return;
        }
        if(n==2) {
            System.out.println(3);
            return;
        }
        if(n==3) {
            System.out.println(5);
            return;
        }
        if(n==4) {
            System.out.println(11);
            return;
        }

        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        dp[4] = 11;

        for(int i = 5 ; i<=n ; i ++) {

            if(i % 2 == 0) {
                dp[i] = (dp[i-1]*2 +1) % 10007;
            }else {
                dp[i] = (dp[i-1]*2 -1) % 10007;
            }

        }
        // 1  3  5  11  21
        //dp[1] = 1;
        //dp[2] = 1 + 1*2 = 3 ;
        //dp[3] = 1 + 4 = 5;
        //dp[4] = 1 + 6 + 4 = 11
        //dp[5] = 1 + 12 + 8 = 21;


        System.out.println(dp[n]);

    }


    }


