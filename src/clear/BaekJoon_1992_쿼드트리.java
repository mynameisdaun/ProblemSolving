package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_1992_쿼드트리 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BaekJoon_1992_쿼드트리 main = new BaekJoon_1992_쿼드트리();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            int[] input = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0 ; j < N ; j ++) {
                board[i][j] = input[j];
            }
        }
        isCompressPossible(0,0, N, board);
        System.out.println(sb.toString());
    }
    //압축가능한지 확인
    public static boolean isSameNumber(int x, int y, int size, int[][] board) {
        int number = board[x][y];
        for(int i = x ; i < x + size ; i++) {
            for(int j = y ; j < y + size ; j ++) {
                if(board[i][j]!=number) return false;
            }
        }
        return true;
    }

    public static void isCompressPossible(int x, int y, int size, int[][] board) {
        if(size==1|| isSameNumber(x,y,size,board)) {
            sb.append(board[x][y]);
        } else {
            int[] dx = {0, 0, size/2, size/2};
            int[] dy = {0, size/2, 0, size/2};
            sb.append("(");
            for(int i = 0 ; i < 4 ; i ++) {
                isCompressPossible(x+dx[i],y+dy[i],size/2, board);
            }
            sb.append(")");
        }
    }
}

