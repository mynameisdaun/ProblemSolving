package challenging;

import java.io.IOException;

public class Main {
    private static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        int n = 6;
        int[][] arr = {
                {1, 2, 2},
                {1, 3, 5},
                {1, 4, 1},
                {2, 3, 3},
                {2, 4, 2},
                {3, 2, 3},
                {3, 6, 5},
                {4, 3, 3},
                {4, 5, 1},
                {5, 3, 1},
                {5, 6, 2}
        };
        int[][] board = new int[n+1][n+1];
        for(int i = 1 ; i <=n ; i ++) {
            for(int j = 1; j <=n ; j++) {
                if(i==j) {
                    board[i][j] = 0;
                    continue;
                }
                board[i][j]=INF;
            }
        }

        for(int i = 0 ; i < arr.length ; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            int d = arr[i][2];
            board[x][y]=d;
            board[y][x]=d;
        }

        int start = 1;

        for(int k = 1 ; k <= n ; k++) {
            for(int i = 1 ; i <=n ; i++) {
                for(int j = 1; j <=n ; j++) {
                    board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);
                }
            }
        }

        for(int x : board[start]) {
            System.out.println(x);
        }
    }


}
