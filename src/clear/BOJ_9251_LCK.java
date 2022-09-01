package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251_LCK {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A = br.readLine().split("");
        String[] B = br.readLine().split("");
        int[][] board = new int[A.length][B.length];
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i].equals(B[j])) {
                    int max = 0;
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        max += board[i - 1][j - 1];
                    }
                    board[i][j] = max + 1;
                    answer = Math.max(board[i][j], answer);
                } else {
                    if (i - 1 >= 0) {
                        board[i][j] = Math.max(board[i - 1][j], board[i][j]);
                    }
                    if (j - 1 >= 0) {
                        board[i][j] = Math.max(board[i][j - 1], board[i][j]);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
