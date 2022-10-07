package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BOJ_5557_1학년 {
    static int n, seq[];
    static long answer = 0, memo[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        seq = new int[n];
        String[] input = br.readLine().split(" ");
        memo = new long[n][21];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
            seq[i] = Integer.parseInt(input[i]);
        }
        System.out.println(dfs(0, seq[0]));
    }

    static long dfs(int L, int S) {
        if (memo[L][S] != -1) {
            return memo[L][S];
        }
        if (L == n - 2) {
            if (S == seq[n-1]) {
                return memo[L][S] = 1;
            } else {
                return memo[L][S] = 0;
            }
        }
        long sum = 0;
        if (S + seq[L + 1] <= 20) {
            sum += (memo[L + 1][S + seq[L + 1]] = dfs(L + 1, S + seq[L + 1]));
        }
        if (S - seq[L + 1] >= 0) {
            sum += (memo[L + 1][S - seq[L + 1]] = dfs(L + 1, S - seq[L + 1]));
        }
        return memo[L][S] = sum;
    }
}
