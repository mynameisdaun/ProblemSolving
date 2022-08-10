package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DP_최대물건개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = input[0];
        int M = input[1];
        int[][] quizs = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            quizs[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int[] dp = new int[M + 1];
        dp[0] = 0;

        for (int i = 0; i < quizs.length; i++) {
            int score = quizs[i][0];
            int time = quizs[i][1];
            for (int j = M; j >= time; j--) {
                dp[j] = Math.max(dp[j], dp[j-time]+score);
            }
        }
        System.out.println(dp[M]);
    }
}

