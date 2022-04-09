package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알고스팟_게임판_덮기 {
    static int[][] dx = new int[][]{
            {0,1},{0,1},{1,1},{1,1}
    };
    static int[][] dy = new int[][]{
            {1,0},{1,1},{0,1},{-1,0}
    };
    static int row;
    static int col;
    static char[][] board;
    static int dotCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcase = Integer.parseInt(br.readLine());
        while(tcase-->0) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            row = input[0];
            col = input[1];
            dotCount = 0;
            board = new char[row][col];
            for(int i = 0 ; i < row ; ++i) {
                String[] chars = br.readLine().split("");
                for(int j = 0 ; j < col ; ++j) {
                    char c = chars[j].charAt(0);
                    board[i][j] = c;
                    if(c=='.') dotCount++;
                }
            }
            if(dotCount % 3 != 0) {
                System.out.println(0);
                return;
            }
            System.out.println(solution(board));
        }
    }

    public static int solution(char[][] board) {
        int[] a = findFirstBlank(board);
        int x = a[0]; int y = a[1];
        if(x==-1) return 1;
        int temp = 0;
        for(int i = 0 ; i < 4 ; ++i) {
            if(isPossible(x, y, dx[i], dy[i])) {
                convertTo(x, y, dx[i], dy[i], '@');
                temp += solution(board);
                convertTo(x, y, dx[i], dy[i], '.');
            }
        }
        return temp;
    }

    public static int[] findFirstBlank(char[][] board) {
        int x = -1; int y = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '.') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{x, y};
    }

    public static void convertTo(int x, int y, int[] xmove, int[] ymove, char c) {
        board[x][y]=c;
        for(int i = 0 ; i < 2 ; i ++) {
            int nx = x + xmove[i];
            int ny = y + ymove[i];
            board[nx][ny]=c;
        }
    }

    public static boolean isPossible(int x, int y, int[] xmove, int[] ymove) {
        for(int i = 0 ; i < 2 ; i ++) {
            int nx = x + xmove[i];
            int ny = y + ymove[i];
            if( nx<0 || ny < 0 || nx >= row || ny >= col || board[nx][ny] != '.')
                return false;
        }
        return true;
    }
}

