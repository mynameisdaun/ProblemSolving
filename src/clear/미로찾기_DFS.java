package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 미로찾기_DFS {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] board;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        미로찾기_DFS main = new 미로찾기_DFS();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[7][7];
        for(int i = 0 ; i < 7 ; i ++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0 ; j < 7 ; j ++) {
                board[i][j] = arr[j];
            }
        }
        board[0][0]=1;
        main.DFS(0, 0);
        System.out.println(answer);
    }

    void DFS(int x, int y) {
        if(x == 6 && y == 6) {
            answer++;
        }
        else {
            for(int i = 0 ; i < 4 ; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0&&nx<=6&&ny>=0&&ny<=6&&board[nx][ny]==0) {
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }
}
