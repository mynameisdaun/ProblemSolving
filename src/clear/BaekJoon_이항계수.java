package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int K = Integer.parseInt(input1[1]);
        System.out.println(이항계수(N,K, new long[N+1][K+1]));
    }

    public static long 이항계수(int N, int K, long[][] memo) {
        if(memo[N][K]>0) return memo[N][K];
        if(N==K||K==0 ) return memo[N][K]=1;

        return memo[N][K]=
                (이항계수(N-1, K-1, memo)%mod+이항계수(N-1, K, memo)%mod)%mod;
   }
}

