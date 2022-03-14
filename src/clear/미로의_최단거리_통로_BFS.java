package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 미로의_최단거리_통로_BFS {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] board;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        미로의_최단거리_통로_BFS main = new 미로의_최단거리_통로_BFS();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[7][7];
        for(int i = 0 ; i < 7 ; i ++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0 ; j < 7 ; j ++) {
                board[i][j] = arr[j];
            }
        }
        board[0][0] = 1;
        BFS(0, 0);
        if(answer==Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }
    static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(x, y, 0));

        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            if(curr.L >= answer) continue;
            if(curr.x==6 && curr.y==6) {
                answer = Math.min(answer, curr.L);
            }
            for(int i = 0 ; i < 4 ; i ++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(nx>=0&&nx<=6&&ny>=0&&ny<=6&&board[nx][ny]==0) {
                    board[nx][ny]=1;
                    queue.offer(new Point(nx, ny, curr.L+1));
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
