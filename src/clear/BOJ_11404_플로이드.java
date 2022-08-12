package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11404_플로이드 {
    static int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] board = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i++) {
            Arrays.fill(board[i],INF);
            for(int j = 1 ; j <= n ; j++) {
                if(i==j)board[i][j] = 0;
            }
        }

        for(int i = 0 ; i < m ; i++) {
            int[] info = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            board[info[0]][info[1]] = Math.min(info[2], board[info[0]][info[1]]);
        }

        for(int k = 1 ; k <= n ; k++) {
            for(int i = 1 ; i <= n ; i++) {
                for(int j = 1 ; j <= n ; j++) {
                    board[i][j] = Math.min(board[i][j], board[i][k]+board[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                if(board[i][j] >= INF) {
                    sb.append(0 + " ");
                } else {
                    sb.append(board[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

