package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BaekJoon_14502_연구소 {

    static int[][] board;
    static int NumberOfWall = 3;
    static int ROW;
    static int COL;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int answer = Integer.MIN_VALUE;
    static int NumberOfSafeArea = -3;
    static List<Virus> virusList = new ArrayList<Virus>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]arr = br.readLine().split(" ");
        ROW = Integer.parseInt(arr[0]);
        COL = Integer.parseInt(arr[1]);
        board = new int[ROW][COL];

        for(int i = 0 ; i < ROW; i ++) {
            String[]str = br.readLine().split(" ");
            for(int j = 0 ; j < COL; j ++) {
                int num = Integer.parseInt(str[j]);
                board[i][j] = num;
                if(num!=1) NumberOfSafeArea++;
                if(num==2) virusList.add(new Virus(i, j));
            }
        }
        //System.out.println("numberOfSafe: "+NumberOfSafeArea);

        buildWall(0,0);
        System.out.println(answer);
    }

    static boolean buildWall(int L, int start) {
        if(start == ROW*COL) return true;

        if(L==NumberOfWall) {
            int n = countSafeArea(arrayCopy(board));
            if( n > answer) {
                //System.out.println("wefoundanswer!!: "+ n);
                answer=n;
            }
            answer = Math.max(countSafeArea(arrayCopy(board)),answer);
        } else {
            for(int i = start ; i < ROW*COL ; i++) {
                int row = i / COL;
                int col = i % COL;
                if(board[row][col]==0) {
                    board[row][col]=3;
                    //System.out.printf("wall: %d row: %d col : %d \n",i,row,col);
                    boolean b = buildWall(L+1, start+1);
                    if(b) return true;
                    board[row][col]=0;
                }
            }
        }
        return false;
    }

    static int countSafeArea(int[][] copyBoard) {
        int virus = 0 ;
        Queue<Virus> queue = new LinkedList<Virus>(virusList);

//        for(int i = 0 ; i < ROW ; i ++) {
//            for(int j = 0 ; j < COL ; j ++) {
//                System.out.print(copyBoard[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("===============");

        /*for(int i = 0 ; i < ROW*COL ; i++) {
            int x = i / COL;
            int y = i % COL;
            if(copyBoard[x][y]==2) queue.offer(new Virus(x, y));
        }*/

        while(!queue.isEmpty()) {
            virus++;
            Virus curr = queue.poll();
            for(int i = 0 ; i < 4 ; i ++) {
                 int nx = curr.x + dx[i];
                 int ny = curr.y + dy[i];
                 if(nx>=0&&nx<ROW&&ny>=0&&ny<COL&&copyBoard[nx][ny]==0) {
                     copyBoard[nx][ny]=2;
                     queue.offer(new Virus(nx,ny));
                 }
            }
        }
        //System.out.println("virus: "+virus);
        return NumberOfSafeArea - virus;
    }

    static int[][] arrayCopy(int[][] a) {
        int[][] b = new int[a.length][a[0].length];
        for(int i = 0; i<b.length ; i ++) {
            System.arraycopy(a[i], 0, b[i], 0, a[0].length);
        }
        return b;
    }

    static class Virus {
        int x;
        int y;
        public Virus(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

}



