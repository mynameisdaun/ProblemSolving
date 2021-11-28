package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon_2206_벽_부수고_이동하기 {

    static int N, M;
    static int[][] board;
    static boolean[][][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] boardArr = br.readLine().split(" ");
        N = Integer.parseInt(boardArr[0]);
        M = Integer.parseInt(boardArr[1]);
        board = new int[N+1][M+1];
        visited = new boolean[2][N+1][M+1];

        for(int i = 1 ; i<=N; i++) {
            String[] arr = br.readLine().split("");
            for(int j = 1 ; j <= M ; j ++) {
                board[i][j] = Integer.parseInt(arr[j-1]);
            }
        }

        BFS();
        System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);
    }

    static void BFS() {
        Queue<Node> queue = new LinkedList<Node>();

        visited[0][1][1]=true;
        queue.offer(new Node(1,1,1,0));

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if(curr.x == N && curr.y==M){
                answer = curr.distance;
                return;
            }else {
                for(int i = 0 ; i < 4 ; i ++) {
                    int nx = curr.x + dx[i];
                    int ny = curr.y + dy[i];
                    if(nx>=1&&nx<=N&&ny>=1&&ny<=M) {
                        if(board[nx][ny]==1&&curr.breakWall==0) {
                            visited[1][nx][ny] = true;
                            queue.offer(new Node(nx,ny,curr.distance+1, 1));
                        } else if(board[nx][ny]==0&&!visited[curr.breakWall][nx][ny]) {
                            visited[curr.breakWall][nx][ny]=true;
                            queue.offer(new Node(nx,ny,curr.distance+1, curr.breakWall));
                        }
                    }
                }
            }


        }


    }

    static class Node {
        int x;
        int y;
        int distance;
        int breakWall;

        public Node(int x, int y, int distance, int breakWall) {
            this.x=x;
            this.y=y;
            this.distance=distance;
            this.breakWall=breakWall;
        }
    }
}