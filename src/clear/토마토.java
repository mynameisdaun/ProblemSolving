package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 토마토 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] board;
    static int 익지않은토마토수 = 0;
    static List<Point> 익은토마토 = new ArrayList<Point>();
    static int row;
    static int col;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        토마토 main = new 토마토();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        row = input[1];
        col = input[0];
        board = new int[row][col];
        for(int i = 0 ; i < row ; i ++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0 ; j < col ; j ++) {
                board[i][j] = arr[j];
                if(arr[j]==0) 익지않은토마토수++;
                if(arr[j]==1) 익은토마토.add(new Point(i, j,0));
            }
        }
        if(익지않은토마토수 == 0) {
            System.out.println(0);
            return;
        }
        BFS();
        if(익지않은토마토수 > 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }
    static void BFS() {
        Queue<Point> queue = new LinkedList<Point>(익은토마토);

        while(!queue.isEmpty()) {
            Point 토마토 = queue.poll();
            answer = Math.max(answer,토마토.L);
            for(int i = 0 ; i < 4 ; i ++) {
                int nx = 토마토.x + dx[i];
                int ny = 토마토.y + dy[i];
                if(nx>=0&&nx<row&&ny>=0&&ny<col&&board[nx][ny]==0) {
                    board[nx][ny]=1;
                    익지않은토마토수--;
                    queue.offer(new Point(nx, ny, 토마토.L+1));
                }
            }
        }
    }
    static class Point {
        public int x;
        public int y;
        public int L;
        public Point(int x, int y, int L) {
            this.x=x;
            this.y=y;
            this.L=L;
        }
    }
}
