package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 조합의경우수 {

    public static int[][] check;

    public static void main(String[] args) throws IOException {
        조합의경우수 main = new 조합의경우수();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input1[0];
        int r = input1[1];
        check = new int[n+1][n+1];
        System.out.println(main.comb(n,r));
    }

    int comb(int n, int r) {
        if(check[n][r] != 0) {
            return check[n][r];
        }
        if(n==r||r==0) {
            return 1;
        } else {
            return check[n][r] = comb(n-1,r-1)+comb(n-1,r);
        }
    }

}
