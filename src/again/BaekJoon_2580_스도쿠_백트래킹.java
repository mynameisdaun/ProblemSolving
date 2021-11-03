package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_2580_스도쿠_백트래킹 {
    static int[][] board = new int[10][10];
    static boolean[] visited = new boolean[10];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 1 ; i <= 9 ; i ++) {
            String[] arr = br.readLine().split(" ");
            for(int j = 1 ; j <= 9 ; j ++) {
                board[i][j] = Integer.parseInt(arr[j-1]);
            }
        }


        DFS(0);

        //print
        for(int i = 1 ; i <= 9 ; i ++) {
            for(int j = 1 ; j <= 9 ; j ++) {
                    System.out.print(board[i][j]+" ");
                }
            System.out.println( );
        }
    }
    static boolean DFS(int L) {
        if(L==81) return true;

        int row = (L / 9) + 1;
        int col = (L % 9) + 1;

        int curr = board[row][col];
        if(curr != 0) {
            return DFS(L+1);
        } else {
            for(int i = 1 ; i <= 9 ; i ++) {
                board[row][col] = i;
                if (isValidSudoku(row, col)) {
                    boolean flag = DFS(L + 1);
                    if (flag) return true;
                }
            }
            board[row][col] =  0;
            return false;
            }
        }

/*
0 0 0 0 0 0 0 0 0
1 0 0 0 2 0 0 0 0
0 0 0 0 0 3 0 0 4
0 0 5 0 7 0 8 0 0
0 0 0 0 0 0 0 0 0
4 0 0 3 0 0 1 0 2
0 0 0 0 0 0 0 0 0
2 7 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
* */


    static boolean isValidSudoku(int x, int y) {

        for(int i=1 ; i<=3 ; i++) {
            Arrays.fill(visited,false);
            for(int j=1 ; j<=9 ; j++) {
                    if(i==1){
                        //가로
                        if(board[x][j]==0) continue;
                        if(visited[board[x][j]]) return false;
                        visited[board[x][j]] = true;
                    } else if(i==2) {
                        //세로
                        if(board[j][y]==0) continue;
                        if(visited[board[j][y]]) return false;
                        visited[board[j][y]] = true;
                    } else {
                        //크로스
                        int row = ((j-1) / 3+1)+((x-1) / 3*3);
                        int col = ((j-1) % 3+1)+((y-1) / 3*3);
                        if(board[row][col]==0) continue;
                        if(visited[board[row][col]]) return false;
                        visited[board[row][col]] = true;
                    }
            }
        }
        return true;
    }
}



