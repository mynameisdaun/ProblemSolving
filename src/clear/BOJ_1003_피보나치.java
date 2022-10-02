package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1003_피보나치 {

    static int[][] memo = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Arrays.stream(fibo(Integer.parseInt(br.readLine()))).forEach(a->System.out.print(a+" "));
            System.out.println();
        }
    }

    static int[] fibo(int n) {
        //0, 1
        if (memo[n][0] != 0) {
            return memo[n];
        }
        if (n == 1) {
            return new int[]{0, 1};
        }
        if (n == 0) {
            return new int[]{1, 0};
        }
        int[] n1 = fibo(n - 1);
        int[] n2 = fibo(n - 2);
        return memo[n] = new int[]{n1[0] + n2[0], n1[1] + n2[1]};
    }
}
/*
3
0
1
3
->
1 0
0 1
1 2

2
6
22
->
5 8
10946 17711
 */
