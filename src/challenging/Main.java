package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int ROW;
    static int COL;
    static int SECOND;
    static char[][] board;
    static Queue<Bomb> queue = new LinkedList<Bomb>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        ROW = Integer.parseInt(arr[0]);
        COL = Integer.parseInt(arr[1]);
        SECOND = Integer.parseInt(arr[2]);
        board = new char[ROW][COL];

        for(int i = 0 ; i < ROW ; i ++) {
            char[] str = br.readLine().toCharArray();
            for(int j = 0 ; j < COL ; j ++) {
                char curr = str[j];
                board[i][j] = str[j];
                if(curr=='0') queue.offer(new Bomb(i, j, 1));
            }
        }
        BFS();

    }

    static void BFS() {
        int time = 1 ;

        while(!queue.isEmpty()) {


            Bomb curr = queue.poll();

            if(time==SECOND) {
                print();
                return;
            }

            board[curr.x][curr.y] = '.';

            for(int i = 0 ; i < 4 ; i ++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(nx>=0&&nx<ROW&&ny>=0&&ny<COL) {

                }

            }
        }



    }

    static void print() {
        for(int i=0;i<ROW;i++) {
            for(int j=0;j<COL;j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }


    static class Bomb {
        int x;
        int y;
        int time;
        public Bomb(int x, int y, int time) {
            this.x=x;
            this.y=y;
            this.time=time;
        }
    }
}