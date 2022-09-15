package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14499_주사위굴리기 {
    //동,서,북,남
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);
        int y = Integer.parseInt(input[3]);
        int k = Integer.parseInt(input[4]);
        int[][] board = new int[row][col];
        for (int i = 0; i < row; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        Dice dice = new Dice(x, y, 0, 0, 0, 0, 0, 0);

        input = br.readLine().split(" ");

        for (int i = 0; i < k; i++) {
            int d = Integer.parseInt(input[i]);

            int nx = dice.x + dx[d];
            int ny = dice.y + dy[d];

            if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                dice.move(nx, ny, d);
                System.out.println(dice.top);
                if(board[nx][ny]==0) {
                    board[nx][ny] = dice.bottom;
                } else {
                    dice.bottom = board[nx][ny];
                    board[nx][ny] = 0;
                }
            }
        }
    }

    static class Dice {
        private int x;
        private int y;
        private int top;
        private int bottom;
        private int north;
        private int south;
        private int east;
        private int west;


        public Dice(int x, int y, int top, int bottom, int north, int south, int east, int west) {
            this.x = x;
            this.y = y;
            this.top = top;
            this.bottom = bottom;
            this.north = north;
            this.south = south;
            this.east = east;
            this.west = west;
        }

        public void move(int nx, int ny, int d) {
            this.x = nx;
            this.y = ny;
            //동
            int tmp = top;
            if (d == 1) {
                top = west;
                west = bottom;
                bottom = east;
                east = tmp;
            }
            //서
            if (d == 2) {
                top = east;
                east = bottom;
                bottom = west;
                west = tmp;
            }
            //북
            if (d == 3) {
                top = south;
                south = bottom;
                bottom = north;
                north = tmp;
            }
            //남
            if (d == 4) {
                top = north;
                north = bottom;
                bottom = south;
                south = tmp;
            }
        }
    }
}
