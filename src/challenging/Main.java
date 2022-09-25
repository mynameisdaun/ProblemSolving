package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String b = br.readLine();
        String a = br.readLine();
        if(a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int[][] board = new int[a.length() + 1][b.length() + 1];
        int[] max = new int[b.length() + 1];

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    int tmp = 0;
                    for (int k = j - 1; k >= 1; k--) {
                        tmp = Math.max(tmp, max[k]);
                    }
                    board[i][j] = tmp + 1;
                }
            }
            for (int j = 1; j <= b.length(); j++) {
                max[j] = Math.max(max[j], board[i][j]);
            }
        }
        int answer = 0;
        for (int i = 1; i <= b.length(); i++) {
            answer = Math.max(answer, max[i]);
        }
        System.out.println(answer);
//        System.out.println(b);
//        for (int i = 1; i < max.length; i++) {
//            System.out.print(max[i]+" ");
//        }
//        System.out.println();


        if (answer > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = b.length(); i >= 1; i--) {
                if(max[i] == answer) {
                    sb.append(b.charAt(i-1));
                    answer--;
                }
                if(answer==0) break;
            }
            System.out.println(sb.reverse().toString());
        }
    }
}
//반례를 어떻게 만들어볼까?
/*
ABCDE
CDEAB

ABAB
BAB

A
AA

A
AB

ABCDEF
EFDEFACDFAB

BAAB
ABBA

*/
//==> 바로반례다..;;저걸 다봐야된다고 ?기억하게 못하나?


