package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_5569_출근 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int row = input[1];
        int col = input[0];
        // 0 : 아래서, 1: 옆에서
        int[][][][] board = new int[row+1][col+1][2][2];

        for(int i = 2 ; i <= row ; i++) {
            board[i][1][0][0] = 1;
        }

        for(int i = 2 ; i <= col ; i++) {
            board[1][i][1][0] = 1;
        }

        for(int i = 2 ; i <= row ; i++) {
            for(int j = 2 ; j <= col ; j++) {
                //변경 안할꺼니까, 다 가능
                board[i][j][0][0] = (board[i-1][j][0][0] + board[i-1][j][0][1]) % 100000;
                board[i][j][1][0] = (board[i][j-1][1][0] + board[i][j-1][1][1]) % 100000;
                //변경할꺼니까, 변경 안한것만 가능
                board[i][j][0][1] = board[i-1][j][1][0];
                board[i][j][1][1] = board[i][j-1][0][0];
            }
        }

        int answer = 0;
        for(int i = 0 ; i < 2 ; i++) {
            for (int j = 0; j < 2; j++) {
                answer += board[row][col][i][j];
            }
        }
        System.out.println(answer % 100000);
    }

}
