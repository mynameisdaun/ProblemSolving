package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BaekJoon_17141_연구소2 {

    static int[][] board;
    static int NumberOfVirus = 0;
    static int N;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int answer = Integer.MAX_VALUE;
    static int NumberOfSafeArea = 0;
    static List<Virus> virusList = new ArrayList<Virus>();
    static List<Virus> virusLocation = new LinkedList<Virus>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        NumberOfVirus = Integer.parseInt(arr[1]);
        board = new int[N][N];

        for(int i = 0 ; i < N; i ++) {
            String[]str = br.readLine().split(" ");
            for(int j = 0 ; j < N; j ++) {
                int num = Integer.parseInt(str[j]);
                board[i][j] = num;
                if(num!=1) NumberOfSafeArea++;
                if(num==2) virusLocation.add(new Virus(i,j,0));
            }
        }
        if(NumberOfSafeArea==NumberOfVirus) {
            System.out.println(0);
            return;
        }
        spreadVirus(0,0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static boolean spreadVirus(int L, int start) {
        //if(start == virusLocation.size()) return true;

        if(L==NumberOfVirus) {
            answer = Math.min(countTime(arrayCopy(board)),answer);
        } else {
//            for(int i = start ; i < N*N ; i++) {
//                int row = i / N;
//                int col = i % N;
//                if(board[row][col]==2) {
//                    Virus curr = new Virus(row,col,0);
//                    virusList.add(curr);
//                    board[row][col]=3;
//                    boolean b = spreadVirus(L+1, start+1);
//                    if(b) return true;
//                    virusList.remove(curr);
//                    board[row][col]=2;
//                }
             for(int i = start ; i < virusLocation.size() ; i ++) {
                 Virus curr = virusLocation.get(i);
                 if(board[curr.x][curr.y]==2) {
                     virusList.add(curr);
                     board[curr.x][curr.y]=3;
                     boolean b = spreadVirus(L+1, start+1);
                     if(b) return true;
                     virusList.remove(curr);
                     board[curr.x][curr.y]=2;
                 }
             }
        }
        return false;
    }

    static int countTime(int[][] copyBoard) {
        int time = 0 ;
        int NOA = NumberOfSafeArea;
        Queue<Virus> queue = new LinkedList<Virus>(virusList);
//        for(Virus x: queue) {
//            System.out.printf("(%d,%d) ",x.x,x.y);
//        }
//        System.out.println();
        while(!queue.isEmpty()) {
            Virus curr = queue.poll();
            NOA--;
            if(curr.time > answer) return Integer.MAX_VALUE;
            time = Math.max(curr.time, time);
            for(int i = 0 ; i < 4 ; i ++) {
                 int nx = curr.x + dx[i];
                 int ny = curr.y + dy[i];
                 if(nx>=0&&nx<N&&ny>=0&&ny<N&&(copyBoard[nx][ny]==0||copyBoard[nx][ny]==2)) {
                     copyBoard[nx][ny]=3;
                     queue.offer(new Virus(nx,ny,curr.time+1));
                 }
            }
        }
        return NOA > 0 ? Integer.MAX_VALUE : time;
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
        int time;
        public Virus(int x, int y, int time){
            this.x=x;
            this.y=y;
            this.time=time;
        }
    }
}



