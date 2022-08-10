package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_14719_빗물 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = input[0];
        int col = input[1];
        int[][] board = new int[row][col];
        int[] walls = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < walls.length; i++) {
            int wall = walls[i];
            if (wall == 0) continue;
            for (int j = row - 1; j >= row - wall; j--) {
                board[j][i] = 1;
            }
        }

        int answer = 0;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 1) continue;
                if(isSavedWater(i, j, board)) {
                    board[i][j]=2;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean isSavedWater(int x, int y, int[][] board) {
        if(leftSide(x,y,board) && rightSide(x,y,board) && downSide(x, y, board)) {
            return true;
        }
        return false;
    }

    public static boolean leftSide(int x, int y, int[][] board) {
        if(y-1>=0 && (board[x][y-1]==2||board[x][y-1]==1)) {
            return true;
        }
        return false;
    }
    public static boolean rightSide(int x, int y, int[][] board) {
        if(y+1>=board[0].length) return false;
        if(board[x][y+1]==1) return true;
        return rightSide(x, y+1, board);
    }
    public static boolean downSide(int x, int y, int[][] board) {
        if(x+1 == board.length || board[x+1][y]==2||board[x+1][y]==1) {
            return true;
        }
        return false;
    }

    public static void print(int row, int col, int[][] board) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

