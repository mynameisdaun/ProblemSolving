package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_이친수 {

    static long[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //0으로 시작할 수 없음 11이 부분수열로 있으면 안됨 1 ~ 90 3 -> 2
        int n = Integer.parseInt(br.readLine());
        memo = new long[n + 1];
        System.out.println(fibo(n));
        /*
        1 -> 1
        2 -> 1
        3 -> 2
        4 -> 3
         */
        /*   2  3    5    8      13
        // 100 1000 10000 100000  2
                          100001  1
        //          10001 100010  2
        //     1001 10010 100100  2
                          100101  1
        // 101 1010 10100 101000  2
                          101001  1
        //          10101 101010  2
        */
    }

    static long fibo(int n) {
        if (memo[n] > 0) {
            return memo[n];
        }
        if (n == 2 || n == 1) {
            return 1;
        }
        return memo[n] = fibo(n - 1) + fibo(n - 2);
    }
}
