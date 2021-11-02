package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int ROW;
    static int COL;
    static char[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Set<Character> visited = new HashSet<Character>();
    static int answer = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        ROW = Integer.parseInt(str[0]);
        COL = Integer.parseInt(str[1]);
        board = new char[ROW][COL];


        for(int i = 0 ; i < ROW ; i ++) {
            String arr = br.readLine();
            for(int j = 0 ; j < COL ; j ++) {
                board[i][j] = arr.charAt(j);
            }
        }
        DFS(1,0,0);
        System.out.println(answer);


    }

    static void DFS(int L, int x, int y) {
        visited.add(board[x][y]);
        answer = Math.max(L,answer);

        for(int i = 0 ; i < 4 ; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0&&nx<ROW&&ny>=0&&ny<COL&&!visited.contains(board[nx][ny])) {
                //visited.contains(board[nx][ny]);
                DFS(L+1, nx, ny);
                visited.remove(board[nx][ny]);
            }
        }


    }



    static class Node {
        int x;
        int y;
        String path;
        public Node(int x, int y, String path) {
            this.x=x;
            this.y=y;
            this.path=path;
        }
    }

}



