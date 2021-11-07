package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int COL;
    static int ROW;
    static int NumberOfLine;
    static int[][][] board;
    static boolean[][][] visited;
    static int answer = 0;
    static Set<Integer[][][]> set = new HashSet<Integer[][][]>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        COL = Integer.parseInt(str[0]);
        NumberOfLine = Integer.parseInt(str[1]);
        ROW   = Integer.parseInt(str[2]);
        board = new int[ROW+2][COL+1][COL+1];


        for(int i = 0 ; i < NumberOfLine ; i ++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int   end = Integer.parseInt(line[1]);
            board[start][end][end+1] = 1;
            board[start][end+1][end] = 1;

        }


        while(!DFS(0, 1, answer)&&answer<4){
            answer++;
        }

        if(answer>=4) {
            System.out.println(-1);
        }
        else {
            System.out.println(answer);
        }

    }

    static boolean DFS(int L, int start, int numberOfAddedLine) {

        if(L==numberOfAddedLine) {
            //System.out.println("검색을 시작합니다!");
            if(isValidMove()) {
                //System.out.println("numberOfAddedLine: "+ numberOfAddedLine);
                return true;
            }
        } else {
            for(int m = start ; m <=(ROW+1)*(COL+1) ; m ++) {
                    int i = m  / (ROW);
                    int j = m  %  (COL);
                    if(i==0||j==0) continue;
                //System.out.printf("m: %d, i : %d, j : %d \n", m, i, j);
/*
                4 3 4
                11
                22
                13
                답:3
*/
                    int left = j-1;
                    int right = j+1;
                    if(j==COL) {
                        continue;
                    } else {
                        if((j==1&&board[i][j][right]==0)||(board[i][j][left]==0&&board[i][j][right]==0)) {
                            if(j<=COL-2&&board[i][right][right+1]==1) continue;
                            //System.out.printf("<NumberOfAddedLine: %d >i: %d , j: %d , right: %d \n", numberOfAddedLine,i, j, right);
                            board[i][j][right]=1;
                            board[i][right][j]=1;
                            //System.out.printf("%d 행 %d 열에서 오른쪽으로 놨습니다. \n", i, j);
                            boolean b = DFS(L+1, i+1, numberOfAddedLine);
                            if(b) return true;
                            board[i][j][right]=0;
                            board[i][right][j]=0;
                        }
                    }
            }
        }
        return false;
    }



    static boolean isValidMove() {
        for(int i = 1; i <= COL ; i++) {
            //System.out.printf("%d 번째 열을 탐색중입니다. \n", i);
            visited = new boolean[ROW+2][COL+1][COL+1];
            int x = 1;
            int y = i;

            while(x<=ROW) {
                //System.out.printf("x: %d  y: %d \n",x,y);
                int left =  y-1;
                int right = y+1;

                if(left>=1&&!visited[x][y][left]&&!visited[x][left][y]&&board[x][y][left]==1){
                    visited[x][y][left]=true;
                    visited[x][left][y]=true;
                    y = left;
                } else if (right<=COL&&!visited[x][y][right]&&!visited[x][right][y]&&board[x][y][right]==1) {
                    visited[x][y][right]=true;
                    visited[x][right][y]=true;
                    y = right;
                } else {
                    x++;
                }
            }
            if(y != i) return false;
        }
        return true;
    }

}



