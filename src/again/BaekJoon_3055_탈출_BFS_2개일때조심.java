package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/*
50 50
..................................................
............................................XXXXD.
...............................................XXX
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
................................S.................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..............................................*...
..................................................
..................................................
..................................................
*/

public class Main {

    static int R, C;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer = Integer.MAX_VALUE;
    static Node S;
    static Node D;
    static Queue<Node> water = new LinkedList<Node>();
    static Map<Integer,Integer> map = new HashMap<Integer, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] boardArr = br.readLine().split(" ");
        R = Integer.parseInt(boardArr[0]);
        C = Integer.parseInt(boardArr[1]);

        board = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0; j<C; j++) {
                board[i][j] = arr[j];

                if(board[i][j]=='S') {
                    S = new Node(i,j,0);
                }
                if(board[i][j]=='D') {
                    D = new Node(i,j);
                }
                if(board[i][j]=='*') {
                    water.offer(new Node(i,j));
                }
            }
        }

//        if(R==1&&C==1) {
//            System.out.println("KAKTUS");
//            return;
//        }

        BFS();
        System.out.println(answer==Integer.MAX_VALUE ? "KAKTUS" : answer);
    }

    static void BFS() {
        Queue<Node> queue = new LinkedList<Node>();
        visited[S.x][S.y] = true;
        queue.offer(S);
        int init = 0;

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if(curr.x==D.x&&curr.y==D.y) {
                answer = curr.distance;
                return;
            }else {
                if(init == curr.distance) {
                    waterMove();
                    init++;
                }
                for(int i = 0 ; i < 4 ; i ++) {
                    int nx = curr.x + dx[i];
                    int ny = curr.y + dy[i];
                    if(nx>=0&&nx<R&&ny>=0&&ny<C&&!visited[nx][ny]&&(board[nx][ny]=='.'||board[nx][ny]=='D')) {
                        visited[nx][ny]=true;
                        queue.offer(new Node(nx, ny, curr.distance+1));
                    }
                }
            }
        }
    }


    static void waterMove() {
        int len = water.size();

        for(int m = 0 ; m < len ; m ++) {
            Node curr = water.poll();
            for(int i = 0 ; i < 4 ; i ++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(nx>=0&&nx<R&&ny>=0&&ny<C&&board[nx][ny]=='.') {
                    board[nx][ny]='*';
                    water.offer(new Node(nx,ny));
                }
            }
        }

//        for(int i = 0 ; i < R ; i ++) {
//            for(int j = 0 ; j < C ; j ++) {
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("===================");
    }


    static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x=x;
            this.y=y;
            this.distance=distance;
        }

        public Node(int x, int y) {
            this.x=x;
            this.y=y;
        }

    }
}