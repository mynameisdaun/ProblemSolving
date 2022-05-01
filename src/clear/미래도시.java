package clear;

import java.io.IOException;

public class 미래도시 {
    private static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        final int start = 1;
        final int n = 4;
        final int m = 2;
        final int K = 4;
        final int X = 3;
        final int[][] arr = {
                {1, 3},
                {2, 4},
        };

        final int[][] board = new int[n+1][n+1];
        for(int i = 1 ; i <=n ; i++) {
            for(int j = 1 ; j <=n ; j ++) {
                if(i==j) {
                    board[i][j]=0;
                    continue;
                }
                board[i][j]=INF;
            }
        }
        for(int i = 0 ; i < arr.length ; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            board[x][y]=1;
            board[y][x]=1;
        }

        for(int k = 1; k <=n ; k++) {
            for(int i = 1; i <=n ; i++) {
                for(int j = 1; j <=n ; j++) {
                    board[i][j] = Math.min(board[i][j], board[i][k]+board[k][j]);
                }
            }
        }
        int answer = board[start][K]+board[K][X];
        if(answer < INF) {
            System.out.println(answer);
            return;
        }
        System.out.println(-1);
    }
}
