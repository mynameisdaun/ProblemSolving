package clear;

import java.util.ArrayList;
import java.util.List;

class 기둥과보 {

    public int[][] solution(int n, int[][] build_frame) {
        List<int[]> answer = new ArrayList<>();
        int[][][] board = new int[n+1][n+1][2];
        for(int i = 0 ; i < build_frame.length ; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];
            if(b==1) {
                put(board, y, x, a, n);
            }
            if(b==0) {
                delete(board, y, x, a, n);
            }
        }
        for(int i = 0 ; i <= n ; i++) {
            for(int j = 0 ; j <=n ; j++) {
                for(int k = 0; k <= 1 ; k++) {
                    if(board[i][j][k]==1) {
                        answer.add(new int[]{j, i, k});
                    }
                }
            }
        }
        return answer.stream().sorted((a,b) -> {
            if(a[0]!=b[0]) return a[0]-b[0];
            if(a[1]!=b[1]) return a[1]-b[1];
            return a[2]-b[2];
        }).toArray(int[][]::new);
    }

    public void put(int[][][] board, int i, int j, int a, int n) {
        board[i][j][a]=1;
        if(!isPossible(board, n)) {
            board[i][j][a]=0;
        }
    }

    public void delete(int[][][] board, int i, int j, int a, int n) {
        board[i][j][a]=0;
        if(!isPossible(board, n)) {
            board[i][j][a]=1;
        }
    }

    public boolean isPossible(int[][][] board, int n) {
        for(int i = 0 ; i <= n ; i++) {
            for(int j = 0 ; j<= n ; j++) {
                if(board[i][j][0]==1) {
                    if( !(i==0)  &&
                            !(i-1>=0 && board[i-1][j][0]==1) &&
                            !(j-1>=0 && board[i][j-1][1]==1) &&
                            !(board[i][j][1]==1)
                    ) {
                        return false;
                    }
                }
                if(board[i][j][1]==1) {
                    if( !(i-1>=0&&board[i-1][j][0]==1) &&
                            !(i-1>=0&&j+1<=n&&board[i-1][j+1][0]==1) &&
                            !((j-1>=0&&board[i][j-1][1]==1)&&(j+1<=n&&board[i][j+1][1]==1))
                    ) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
