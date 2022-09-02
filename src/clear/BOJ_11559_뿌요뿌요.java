package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BOJ_11559_뿌요뿌요 {
    static int[] dx = {1, 0,-1,0};
    static int[] dy = {0, 1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int row = 12;
        int col = 6;
        String[][] board = new String[row][col];
        for (int i = 0; i < row; i++) {
            board[i] = br.readLine().split("");
        }
        int count = 0;
        while (search(board, row, col)) {
            count++;
            clean(board, row, col);
        }
        System.out.println(count);
    }

    public static boolean search(String[][] board, int row, int col) {
        boolean find = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!board[i][j].equals(".")) {
                    String color = board[i][j];
                    Node start = new Node(i, j);
                    Queue<Node> queue = new LinkedList<Node>();
                    Set<Node> set = new HashSet<>();
                    queue.offer(start);
                    set.add(start);
                    while (!queue.isEmpty()) {
                        Node now = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = now.x + dx[k];
                            int ny = now.y + dy[k];
                            if (nx >= 0 && nx < row && ny >= 0 && ny < col && board[nx][ny].equals(color) && !set.contains(new Node(nx, ny))) {
                                queue.offer(new Node(nx, ny));
                                set.add(new Node(nx, ny));
                            }
                        }
                    }
                    if (set.size() >= 4) {
                        set.stream().forEach(a -> board[a.x][a.y] = ".");
                        find = true;
                    }
                }
            }
        }
        return find;
    }

    public static void clean(String[][] board, int row, int col) {
        for (int j = 0; j < col; j++) {
            int count = 0;
            for (int i = row - 1; i >= 0; i--) {
                if (board[i][j].equals(".")) {
                    count++;
                } else {
                    if(count >= 1) {
                        board[i + count][j] = board[i][j];
                        board[i][j] = ".";
                    }
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (x != node.x) return false;
            return y == node.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
