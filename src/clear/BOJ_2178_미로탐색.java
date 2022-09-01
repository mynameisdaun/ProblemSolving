package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2178_미로탐색 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input =
                Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
        int row = input[0];
        int col = input[1];
        int[][] board = new int[row][col];
        for (int i = 0; i < row; i++) {
            input =
                    Arrays.stream(br.readLine().split(""))
                            .mapToInt(Integer::parseInt).toArray();
            board[i] = input;
        }
        System.out.println(BFS(board, row, col, new Node(0, 0, 1)));
    }

    public static int BFS(int[][] board, int row, int col, Node start) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.x == row-1 && now.y == col-1) {
                return now.l;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && board[nx][ny] == 1) {
                    board[nx][ny]=0;
                    queue.offer(new Node(nx, ny, now.l +1 ));
                }
            }
        }
        return 0;
    }

    static class Node {
        int x;
        int y;
        int l;

        public Node(int x, int y, int l) {
            this.x = x;
            this.y = y;
            this.l = l;
        }
    }


}

