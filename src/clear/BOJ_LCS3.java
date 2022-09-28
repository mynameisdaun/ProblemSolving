package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_LCS3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        String abc = LCS(a,b,c);
        System.out.println(abc);
        System.out.println(abc.length());
    }

    static String LCS(String a, String b, String c) {

        int x = a.length();
        int y = b.length();
        int z = c.length();

        int[][][] board = new int[x + 1][y + 1][z + 1];

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                for (int k = 1; k <= z; k++) {
                    if (a.charAt(i - 1) == b.charAt(j - 1) && b.charAt(j - 1) == c.charAt(k - 1)) {
                        board[i][j][k] = board[i - 1][j - 1][k - 1] + 1;
                    } else {
                        board[i][j][k] = Math.max(board[i - 1][j][k], board[i][j - 1][k]);
                        board[i][j][k] = Math.max(board[i][j][k], board[i][j][k - 1]);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = x;
        int j = y;
        int k = z;
        while (i > 0 && j > 0 && k > 0) {
            if (board[i - 1][j][k] == board[i][j][k]) {
                i--;
            } else if (board[i][j - 1][k] == board[i][j][k]) {
                j--;
            } else if (board[i][j][k - 1] == board[i][j][k]) {
                k--;
            } else {
                sb.append(c.charAt(k - 1));
                i--;
                j--;
                k--;
            }
        }
        return sb.reverse().toString();
    }
}

/*
ABCDEF
BEFDEFACDFABZ
ABCDE
CDEAB
ABCDE
ABCDE
CDABE
CBADE
 */
