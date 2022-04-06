package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] answer = new int[3];

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0 ; j < N ; j ++) {
                board[i][j] = input[j];
            }
        }
        isCompressPossible(0,0, N, board);
        for(int x : answer) {
            System.out.println(x);
        }
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
            answer[board[x][y]+1] = answer[board[x][y]+1]+1;
        } else {
            int oneThird = size/3;
            int twoThird = size/3 * 2;
            int[] dx = {0,0,0,oneThird,oneThird,oneThird,twoThird,twoThird,twoThird};
            int[] dy = {0,oneThird,twoThird,0,oneThird,twoThird,0,oneThird,twoThird};
            for(int i = 0 ; i < 9 ; i ++) {
                isCompressPossible(x+dx[i],y+dy[i],size/3, board);
            }
        }
    }
}

