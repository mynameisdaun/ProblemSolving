package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 공통부분문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A = br.readLine().split("");
        String[] B = br.readLine().split("");
        int answer = 0;
        int[][] board = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i].equals(B[j])) {
                    int before = 0;
                    if (i - 1 >= 0 && j - 1 >= 0) before += board[i - 1][j - 1];
                    board[i][j] = 1 + before;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }
        System.out.println(answer);
    }
}
