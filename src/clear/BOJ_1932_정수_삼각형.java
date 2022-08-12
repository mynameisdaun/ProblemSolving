package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1932_정수_삼각형 {
    static int empty = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], empty);
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < input.length; j++) {
                board[i][j] = input[j];
            }
        }
        int[][] dp = new int[N][N];
        dp[0][0] = board[0][0];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (board[i][j] == empty) break;
                //왼쪽
                if (j - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + board[i][j], dp[i][j]);
                }
                //오른쪽
                if (board[i - 1][j] != empty) {
                    dp[i][j] = Math.max(dp[i - 1][j] + board[i][j], dp[i][j]);
                }
            }
        }
        int answer = empty;
        for (int i = 0; i < dp.length; i++) {
            answer = Math.max(answer, dp[N-1][i]);
        }
        System.out.println(answer);
    }
}

