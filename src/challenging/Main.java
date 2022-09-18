package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static String board[][], visited = "x";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new String[n][n];
        for (int i = 0; i < n; i++) board[i] = br.readLine().split("");
        System.out.print(bfs(copy())+" ");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                if(board[i][j].equals("G")) board[i][j] = "R";
            }
        }
        System.out.println(bfs(board));
    }

    static int bfs (String[][] copy) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!copy[i][j].equals(visited)) {
                    Queue<Node> queue = new LinkedList<>();
                    queue.offer(new Node(i, j, copy[i][j]));
                    answer++;
                    while (!queue.isEmpty()) {
                        Node curr = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = curr.x + dx[k];
                            int ny = curr.y + dy[k];
                            if(nx>=0&&nx<n&&ny>=0&&ny<n&&!visited.equals(copy[nx][ny])&&curr.c.equals(copy[nx][ny])){
                                copy[nx][ny] = visited;
                                queue.offer(new Node(nx, ny, curr.c));
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

    static String[][] copy() {
        String[][] copy = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }

    static class Node {
        private int x;
        private int y;
        private String c;

        public Node(int x, int y, String c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

}


