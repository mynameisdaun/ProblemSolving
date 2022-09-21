package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class BOJ_2096_내려가기 {

    static int N, board[][], dp[][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());
        board = new int[N][3];
        dp = new int[N][3][2];

        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < 2; i++) {
            dp[0][0][i] = board[0][0];
            dp[0][1][i] = board[0][1];
            dp[0][2][i] = board[0][2];
        }

        for (int i = 1; i < N; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][1][0]) + board[i][0];
            dp[i][1][0] = Math.max(Math.max(dp[i - 1][0][0], dp[i - 1][1][0]), dp[i - 1][2][0]) + board[i][1];
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][0]) + board[i][2];

            dp[i][0][1] = Math.min(dp[i - 1][0][1], dp[i - 1][1][1]) + board[i][0];
            dp[i][1][1] = Math.min(Math.min(dp[i - 1][0][1], dp[i - 1][1][1]), dp[i - 1][2][1]) + board[i][1];
            dp[i][2][1] = Math.min(dp[i - 1][2][1], dp[i - 1][1][1]) + board[i][2];
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            max = Math.max(dp[N - 1][i][0], max);
            min = Math.min(dp[N - 1][i][1], min);
        }
        System.out.println(max + " " + min);
    }
}

