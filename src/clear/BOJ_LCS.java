package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_LCS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String b = br.readLine();
        String a = br.readLine();
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int[][] board = new int[a.length() + 1][b.length() + 1];
        int[] max = new int[b.length() + 1];

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    board[i][j] = board[i - 1][j - 1] + 1;
                    max[j] = Math.max(max[j], board[i][j]);
                } else {
                    board[i][j] = Math.max(board[i][j - 1], board[i - 1][j]);
                }
            }
        }
        System.out.println(board[a.length()][b.length()]);

        StringBuilder sb = new StringBuilder();
        int i = a.length();
        int j = b.length();
        while (i > 0 && j > 0) {
            if (board[i - 1][j] == board[i][j]) {
                i--;
                continue;
            }
            if (board[i][j - 1] == board[i][j]) {
                j--;
                continue;
            }
            sb.append(b.charAt(j-1));
            i--;
            j--;
        }
        System.out.println(sb.reverse().toString());
    }
}
//반례를 어떻게 만들어볼까?
/*
ABCDE
CDEAB
=> CDE
ABAB
BAB
=> BAB
A
AA
=> A
A
AB
=> 0
ABCDEF
EFDEFACDFAB
=> ACDE
BAAB
ABBA

ABCDEF
BEFDEFACDFABZ
=> ACDF
*/

// 1

//     EF
