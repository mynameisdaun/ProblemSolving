package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17080_파이프옮기기1 {
    static int answer = 0;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        board[0][0] = 1;
        board[0][1] = 1;
        Node tail = new Node(0, 1, 0);
        dfs(tail, board, n);
        System.out.println(answer);
    }

    public static void dfs(Node node, int[][] board, int n) {
        if (node.x == n - 1 && node.y == n - 1) {
            answer++;
            return;
        } else {
            if (diagonal(node, board, n)) {
                moveDiagonal(node, board, n);
            }

            if (node.d == 0 && right(node, board, n)) {
                moveRight(node, board, n);
            } else if (node.d == 1 && bottom(node, board, n)) {
                moveBottom(node, board, n);
            } else {
                if (right(node, board, n)) {
                    moveRight(node, board, n);
                }
                if (bottom(node, board, n)) {
                    moveBottom(node, board, n);
                }
            }
        }
    }


    static boolean diagonal(Node node, int[][] board, int n) {
        int nx = node.x + dx[2];
        int ny = node.y + dy[2];
        return nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0 && right(node, board, n) && bottom(node, board, n);
    }

    static void moveDiagonal(Node node, int[][] board, int n) {
        int nx = node.x + dx[2];
        int ny = node.y + dy[2];
        board[nx][ny] = 1;
        dfs(new Node(nx, ny, 2), board, n);
        board[nx][ny] = 0;
    }

    static boolean right(Node node, int[][] board, int n) {
        int nx = node.x + dx[0];
        int ny = node.y + dy[0];
        return nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0;
    }

    static void moveRight(Node node, int[][] board, int n) {
        int nx = node.x + dx[0];
        int ny = node.y + dy[0];
        board[nx][ny] = 1;
        dfs(new Node(nx, ny, 0), board, n);
        board[nx][ny] = 0;
    }

    static boolean bottom(Node node, int[][] board, int n) {
        int nx = node.x + dx[1];
        int ny = node.y + dy[1];
        return nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0;
    }

    static void moveBottom(Node node, int[][] board, int n) {
        int nx = node.x + dx[1];
        int ny = node.y + dy[1];
        board[nx][ny] = 1;
        dfs(new Node(nx, ny, 1), board, n);
        board[nx][ny] = 0;
    }

    static class Node {
        int x;
        int y;
        int d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}


