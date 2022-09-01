package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17144_공기청정기 {
    static int[] dx = {0,-1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = input[0];
        int col = input[1];
        int time = input[2];
        int upperCleaner = -1;
        int lowerCleaner = -1;
        int[][] board = new int[row][col];
        for (int i = 0; i < row; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < col; j++) {
                board[i][j] = input[j];
                if (board[i][j] == -1) {
                    if (upperCleaner < 0) {
                        upperCleaner = i;
                    } else {
                        lowerCleaner = i;
                    }
                }
            }
        }
        while (time-- > 0) {
            boolean[][] check = new boolean[row][col];
            int[][] copy = arrayCopy(board);
            //미세먼지 확장
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!check[i][j] && board[i][j] > 0) {
                        int sum = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < row && ny >= 0 && ny < col && board[nx][ny] >= 0) {
                                int amount = board[i][j] / 5;
                                copy[nx][ny] += amount;
                                sum += amount;
                            }
                        }
                        copy[i][j] -= sum;
                    }
                }
            }
            //미세먼지 청소기 위쪽 처리
            //미세먼지의 위 -> 아래
            for (int i = upperCleaner - 1; i > 0; i--) {
                copy[i][0] = copy[i - 1][0];
            }
            //미세먼지 우 ->  좌
            for (int i = 0; i < col - 1; i++) {
                copy[0][i] = copy[0][i + 1];
            }
            //미세먼지 아래 -> 위
            for (int i = 0; i < upperCleaner ; i++) {
                copy[i][col - 1] = copy[i + 1][col - 1];
            }
            //미세먼지 좌 > 우
            for (int i = col - 1; i > 1; i--) {
                copy[upperCleaner][i] = copy[upperCleaner][i - 1];
            }
            copy[upperCleaner][1] = 0;

            //미세먼지 청소기 아래쪽 처리
            //아래 -> 위
            for (int i = lowerCleaner + 1; i < row - 1; i++) {
                copy[i][0] = copy[i + 1][0];
            }
            //우, 좌
            for (int i = 0; i < col - 1; i++) {
                copy[row - 1][i] = copy[row - 1][i + 1];
            }
            //미세먼지 위 -> 아래
            for (int i = row - 1; i > lowerCleaner; i--) {
                copy[i][col - 1] = copy[i - 1][col - 1];
            }
            //미세먼지 좌 > 우
            for (int i = col - 1; i > 1; i--) {
                copy[lowerCleaner][i] = copy[lowerCleaner][i - 1];
            }
            copy[lowerCleaner][1] = 0;

            board = copy;
        }

        //먼지 세기
        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] > -1) {
                    answer += board[i][j];
                }
            }
        }
        System.out.println(answer);
    }

    public static int[][] arrayCopy(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }
}
