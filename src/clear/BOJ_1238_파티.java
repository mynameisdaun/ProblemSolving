package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1238_파티 {
    static int INF = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];
        int X = input[2];

        int[][] board = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(board[i], INF);
        }

        for (int i = 0; i < M; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = input[0];
            int y = input[1];
            board[x][y] = Math.min(board[x][y], input[2]);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(i==j) {
                        board[i][j]=0;
                        continue;
                    }
                    board[i][j] = Math.min(board[i][j], board[i][k]+board[k][j]);
                }
            }
        }
        int max = -1;
        for(int i = 1 ; i <= N ; i++) {
            max = Math.max(max, board[i][X]+board[X][i]);
        }
        System.out.println(max);
    }
}
