package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_15684_사다리조작 {

    static int N;
    static int M;
    static int H;
    static int board[][];
    static int NumberOfLine = 0;
    static int[] C = {};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        H = Integer.parseInt(str[2]);
        board = new int[H+1][N+1];

        for(int i = 0 ; i < M ; i ++) {
            String[] arr = br.readLine().split(" ");
            int h = Integer.parseInt(arr[0]);
            int start = Integer.parseInt(arr[1]);
            int end = start+1;
            board[h][start] = 1;
            board[h][end]   = 2;
        }
        while(!DFS(0,NumberOfLine,1)){
            NumberOfLine++;
            C = new int[NumberOfLine];
            if(NumberOfLine>=4) break;
        };
        System.out.println(NumberOfLine >=4 ? -1 : NumberOfLine);


    }

    static boolean DFS(int L, int NumberOfLine, int start) {
        if(start==(H*N)+1) return true;

        if(L==NumberOfLine) {
            return isValidLadder() ? true : false;
        }
        else {
            for(int i = start ; i <= H*N ; i++) {
                int row = ((i-1)/N)+1;
                int col = i % N == 0 ? N : i % N;
                if(col!=N&&board[row][col]==0&&board[row][col+1]!=1) {
                    board[row][col]   = 1;
                    board[row][col+1] = 2;
                    C[L] = i;
//                    for(int j = 0 ; j < C.length ; j ++) {
//                        System.out.printf(C[j]+" ");
//                    }
//                    System.out.println();
                    //if(L>=1&&C[L-1]>i) continue;
                    //System.out.printf("NumberOfLine: %d i: %d row: %d col: %d \n", NumberOfLine,i, row, col);
                    boolean b = DFS(L+1, NumberOfLine, start+2);
                    if(b) return true;
                    board[row][col] = board[row][col+1] = 0;
                }
            }
        }
        return false;
    }


    static boolean isValidLadder() {
        for(int i = 1 ; i <=N; i++) {
            int row = 1;
            int col = i;
            while(row<=H) {
                //System.out.printf("NumberOfLine: %d i: %d row: %d col: %d \n", NumberOfLine,i, row, col);
                if(board[row][col]==1) {
                    col++;
                } else if(board[row][col]==2) {
                    col--;
                }
                row++;
            }
            if(col!=i) return false;
        }
        return true;
    }

}



