package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int[][]board;
    static boolean[][]visited;
    static int highest = Integer.MIN_VALUE;
    static int answer = 0;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i = 0 ; i < N ; i ++) {
            String[] arr = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++) {
                board[i][j] = Integer.parseInt(arr[j]);
                highest = Math.max(highest, board[i][j]);
            }
        }

        for(int i = 0 ; i <= highest ; i ++) {
            answer = Math.max(answer, countSafeArea(i));
        }

        System.out.println(answer);
    }

    static int countSafeArea(int height) {
        visited = new boolean[N][N];
        int count = 0;
        for(int i = 0 ; i < N*N ; i ++) {
            int row = i / N;
            int col = i % N;

            if(board[row][col] > height && !visited[row][col]) {
                count++;
                visited[row][col] = true;
                BFS(new Node(row, col), height);
            }

        }
        return count;
    }

    static void BFS(Node node, int height) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            //visited[curr.x][curr.y] = true;
            for(int i = 0 ; i < 4 ; i ++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]&&board[nx][ny]>height) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny));
                }
            }

        }
    }

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


