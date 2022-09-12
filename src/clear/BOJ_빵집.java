package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_빵집 {
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};

    static String[][] board;
    static int row;
    static int col;
    static int answer = 0;
    static boolean finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        row = input[0];
        col = input[1];
        board = new String[row][col];

        for (int i = 0; i < row; i++) {
            board[i] = br.readLine().split("");
        }

        for (int i = 0; i < row; i++) {
            finished = false;
            board[i][0] = "x";
            move(i, 0);
        }
        System.out.println(answer);
    }

    public static void move(int x, int y) {
        if (y == col - 1) {
            finished = true;
            answer++;
            return;
        }
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!finished && nx >= 0 && nx < row && ny < col && board[nx][ny].equals(".")) {
                board[nx][ny] = "x";
                move(nx, ny);
            }
        }
    }
}
