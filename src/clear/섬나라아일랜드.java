package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 섬나라아일랜드 {

    static int[][] board;
    static int N;
    static int answer;
    static int[] dx = {-1, 0, 1, 0,1,1,-1,-1};
    static int[] dy = {0, -1, 0, 1,1,-1,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N+1][N+1];
        for(int i = 1; i <= N ; i ++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 1 ; j <= N ; j ++) {
                board[i][j] = input[j-1];
            }
        }

        for(int i = 1; i <= N ; i ++) {
            for(int j = 1 ; j <= N ; j ++) {
                if(board[i][j]==1) {
                    answer++;
                    board[i][j]=0;
                    DFS(i,j);
                }
            }
        }
        System.out.println(answer);
    }

    static void DFS(int x, int y) {
        for(int i = 0 ; i < dx.length ; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=1&&nx<=N&&ny>=1&&ny<=N&&board[nx][ny]==1) {
                board[nx][ny]=0;
//                for(int m = 1 ; m <= N ; m++) {
//                    for(int n =1 ; n <=N ; n++) {
//                        System.out.print(board[m][n]);
//                    }
//                    System.out.println();
//                }
//                System.out.println("==================");
                DFS(nx, ny);
            }
        }

    }

}
