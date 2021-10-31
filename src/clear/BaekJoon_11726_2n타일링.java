package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

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
            System.out.println(2);
            return;
        }
        if(n==3) {
            System.out.println(3);
            return;
        }
        if(n==4) {
            System.out.println(5);
            return;
        }

        dp[1] = 0 + 1;    //1
        dp[2] = 1 + 0 + 1;        //3
        dp[3] = 0 + 2 + 0 + 1; //3
        dp[4] = 1 + 0 + 3 + 0 + 1;   //5

        for(int i=5 ;i <=n ; i ++) {
            dp[i] = (dp[i-1]+dp[i-2])%10007;
        }
//        dp[1] = 0 + 1;    //1
//        dp[2] = 1 + 0 + 1;        //3
//        dp[3] = 0 + 2 + 0 + 1; //3
//        dp[4] = 1 + 0 + 3 + 0 + 1;   //5
//        dp[5] = 0 + 3 + 0 + 4 + 0 + 1; //8
//        dp[6] = 1 + 0 + 6 + 0 + 5 + 0 + 1; //13
//        dp[7] = 0 + 4 + 0 + 10 + 0 + 6 + 0 + 1; //21

        System.out.println(dp[n]);

        }


    }


