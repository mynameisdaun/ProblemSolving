package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14503_로봇청소기 {
    //동북서남
    // 0 북 1 동 2 남 3 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays
                .stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row = input[0];
        int col = input[1];
        input = Arrays
                .stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int robotR = input[0];
        int robotC = input[1];
        int robotD = input[2];
        int[][] board = new int[row][col];
        for (int i = 0; i < row; i++) {
            input = Arrays
                    .stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < col; j++) {
                board[i][j] = input[j];
            }
        }
        board[robotR][robotC]=2;
        moveRobot(board, row, col, robotR, robotC, robotD);
        System.out.println(answer);
    }

    public static void moveRobot(int[][] board, int row, int col, int robotR, int robotC, int robotD) {
        //print(board, robotR, robotC);
        //rotate
        //check
        int cnt = 0;
        int nx=0;
        int ny=0;
        int d = robotD;
        while (cnt < 4) {
            d = d - 1 == -1 ? 3 : d -1;
            nx = robotR + dx[d];
            ny = robotC + dy[d];
            if (nx >= 0 && nx < row && ny >= 0 && ny < col && board[nx][ny] == 0) {
                break;
            }
            cnt++;
        }
        //4방향 중 청소할 곳 있음
        if (cnt < 4) {
            answer++;
            board[nx][ny]=2;
            moveRobot(board, row, col, nx, ny, d);
        } else {
            // 0 북 1 동 2 남 3 서
            if(robotD==0&&robotR+1<row&&board[robotR+1][robotC]==2) {
                moveRobot(board, row, col, robotR+1, robotC, robotD);
            }
            if(robotD==1&&robotC-1>=0&&board[robotR][robotC-1]==2) {
                moveRobot(board, row, col, robotR, robotC-1, robotD);
            }
            if(robotD==2&&robotR-1>=0&&board[robotR-1][robotC]==2) {
                moveRobot(board, row, col, robotR-1, robotC, robotD);
            }
            if(robotD==3&&robotC+1<col&&board[robotR][robotC+1]==2) {
                moveRobot(board, row, col, robotR, robotC+1, robotD);
            }
        }
    }

    public static void print(int[][] board, int robotR, int robotC) {
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j <board[0].length ; j++){
                if(robotR==i&&robotC==j) {
                    System.out.print("R ");
                } else {
                    System.out.print(board[i][j]+" ");
                }
            }
            System.out.println();
        }
        System.out.println("=================");
    }

}

