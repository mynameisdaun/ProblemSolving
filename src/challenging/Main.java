package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M;
    static Node start;
    static Node end;
    static int[][] board;
    static Queue<Node> wallQueue = new LinkedList<Node>();
    static int answer = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        String[] startArr = br.readLine().split(" ");
        String[] endArr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);
        start = new Node(Integer.parseInt(startArr[0]),Integer.parseInt(startArr[1]));
        end   = new Node(Integer.parseInt(endArr[0]),Integer.parseInt(endArr[1]));
        board = new int[N+1][M+1];

        for(int i = 1 ; i <= N ; i ++) {
            String[] boardArr = br.readLine().split(" ");
            for(int j = 1 ; j <=M; j ++) {
                board[i][j] = Integer.parseInt(boardArr[j-1]);
                if(board[i][j] == 1)
                    wallQueue.offer(new Node(i,j));
            }
        }

        while(!wallQueue.isEmpty()) {
            visited = new boolean[N+1][M+1];
            Node curr = wallQueue.poll();
            visited[start.x][start.y] = true;
            board[curr.x][curr.y] = 0;
//            for(int i = 1 ; i <= N ; i++) {
//                for(int j = 1; j <=M ; j++) {
//                    System.out.print(board[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("============");
            DFS(0,new Node(start.x, start.y));
            board[curr.x][curr.y] = 1;
        }

        if(answer==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }

        System.out.println(answer);

    }

    static void DFS(int L, Node node) {
        if(L >= answer) return;

        if(node.x == end.x && node.y == end.y) {
            //System.out.println(L);
            answer = Math.min(answer, L);
        } else {

            for(int i = 0 ; i < 4 ; i ++) {
              int nx = node.x + dx[i];
              int ny = node.y + dy[i];
                if(nx>=1&&nx<=N&&ny>=1&&ny<=M&&!visited[nx][ny]&&board[nx][ny]==0) {
                    board[nx][ny]=3;
//                    for(int k = 1 ; k <= N ; k++) {
//                        for(int j = 1; j <=M ; j++) {
//                            System.out.print(board[k][j]+" ");
//                        }
//                        System.out.println();
//                    }
//                    System.out.println("============");
                    visited[nx][ny]=true;
                  DFS(L+1, new Node(nx, ny));
                  visited[nx][ny]=false;
                  board[nx][ny]=0;
              }
            }
        }
    }

    static class Node {
        int x;
        int y;
        public Node (int x, int y) {
            this.x=x;
            this.y=y;
        }
    }


}


