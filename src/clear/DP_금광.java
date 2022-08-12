package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DP_금광 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcase = Integer.parseInt(br.readLine());

        for (int t = 0; t < tcase; t++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int row = input[0];
            int col = input[1];
            int[][] board = new int[row][col];
            input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int i = 0; i < input.length; i++) {
                int r = i / col;
                int c = i % col;
                board[r][c] = input[i];
            }
            int[][] dp = DP(row, col, board);
            int answer = Integer.MIN_VALUE;
            for(int i = 0 ; i < row ; i++) {
                answer = Math.max(dp[i][col-1],answer);
            }
            System.out.println(answer);
        }
    }

    public static int[][] DP(int row, int col, int[][] board) {
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            dp[i][0] = board[i][0];
        }
        for (int i = 1; i < col; i++) {
            for (int j = 0; j < row; j++) {
                dp[j][i] = Math.max(dp[j][i - 1] + board[j][i], dp[j][i]);
                //왼쪽위 존재
                if (j - 1 >= 0) {
                    dp[j][i] = Math.max(dp[j-1][i-1]+board[j][i], dp[j][i]);
                }
                //왼쪽 아래 존재
                if (j + 1 < row) {
                    dp[j][i] = Math.max(dp[j+1][i-1]+board[j][i], dp[j][i]);
                }
            }
        }
        return dp;
    }

    public static void print(int[][] board) {
        int r = board.length;
        int c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
        System.out.println();
    }
}
//2
//3 4
//1 3 3 2 2 1 4 1 0 6 4 7
//4 4
//1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
