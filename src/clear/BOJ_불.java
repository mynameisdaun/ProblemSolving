package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_불 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] board;
    static int row, col;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static Queue<Node> me;

    static Queue<Node> fires;


    public static void main(String[] args) throws IOException {
        int t = input()[0];
        while (t-- > 0) {
            success = false;
            init();
            int time = 0;
            while (true) {
                moveFires(time);
                moveMe(time);
                if (success || me.isEmpty()) {
                    break;
                }
                time++;
            }
            System.out.println(success ? time + 1 : "IMPOSSIBLE");
        }
    }

    static boolean success;

    static void moveMe(int time) {
        while (!me.isEmpty() && me.peek().t == time) {
            Node node = me.poll();
            if (node.isBorder()) {
                success = true;
                return;
            }
            int x = node.x;
            int y = node.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= row && ny >= 1 && ny <= col && board[nx][ny] == '.') {
                    board[nx][ny] = '@';
                    me.offer(new Node(nx, ny, time + 1));
                }
            }
        }
    }

    static void moveFires(int time) {
        while (!fires.isEmpty() && fires.peek().t == time) {
            Node fire = fires.poll();
            int x = fire.x;
            int y = fire.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= row && ny >= 1 && ny <= col && board[nx][ny] == '.') {
                    board[nx][ny] = '*';
                    fires.offer(new Node(nx, ny, time + 1));
                }
            }
        }
    }

    static void init() throws IOException {
        int[] input = input();
        row = input[1];
        col = input[0];
        fires = new LinkedList<>();
        me = new LinkedList<>();
        board = new char[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 1; j <= col; j++) {
                board[i][j] = chars[j - 1];
                if (board[i][j] == '@') {
                    me.add(new Node(i, j, 0));
                }
                if (board[i][j] == '*') {
                    fires.add(new Node(i, j, 0));
                }
            }
        }
    }

    static int[] input() throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    static class Node {
        private int x;
        private int y;

        private int t;

        public Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }

        public boolean isBorder() {
            return x == 1 || y == 1 || x == row || y == col;
        }
    }
}
/*
1
4 3
####
#*@.
####
 */
