package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2933_미네랄 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int r;
    static int c;
    static String[][] board;
    static String[][] copy;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        r = arr[0];
        c = arr[1];
        board = new String[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            String[] input = br.readLine().split("");
            for (int j = 1; j <= c; j++) {
                board[i][j] = input[j - 1];
            }
        }
        int n = Integer.parseInt(br.readLine());
        int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < heights.length; i++) {
            int removed = remove(i + 1, heights[i]);
            if (removed != -1) {
                count = 200;
                checkCluster(i + 1, heights[i]);
            }
        }
        print();
    }

    public static void print() {
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                System.out.print(board[i][j] + "");
            }
            if (i != r) {
                System.out.println();
            }
        }
    }

    public static void checkCluster(int seq, int height) {
        // 어떤 애들이 내려와야되는지 확인하고,
        copy = copy();
        // 안전한 클러스터 확인 후 S로 변환
        for (int i = 1; i <= c; i++) {
            if (copy[r][i].equals("x")) {
                copy[r][i] = "S";
                dfs(r, i, copy);
            }
        }
        // 얼마나 내려야 하는지 확인
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (copy[i][j].equals("x")) {
                    copy[i][j] = "R";
                    calculate(i, j, copy);
                    clean();
                    return;
                }
            }
        }
    }

    public static void clean() {
        for (int i = r; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (copy[i][j].equals("R")) {
                    board[i + count][j] = board[i][j];
                    board[i][j] = ".";
                }
            }
        }
    }

    public static void calculate(int x, int y, String[][] copy) {
        int index = 1;
        while (x + index < r && !copy[x + 1 + index][y].equals("S")) {
            index++;
        }
        count = Math.min(index, count);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 1 && nx <= r && ny >= 1 && ny <= c && copy[nx][ny].equals("x")) {
                copy[nx][ny] = "R";
                calculate(nx, ny, copy);
            }
        }
    }

    public static void dfs(int x, int y, String[][] copy) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 1 && nx <= r && ny >= 1 && ny <= c && copy[nx][ny].equals("x")) {
                copy[nx][ny] = "S";
                dfs(nx, ny, copy);
            }
        }
    }

    public static int remove(int seq, int height) {
        if (seq % 2 != 0) {
            for (int i = 1; i <= c; i++) {
                if (board[r - height + 1][i].equals("x")) {
                    board[r - height + 1][i] = ".";
                    return i;
                }
            }
        } else {
            for (int i = c; i >= 1; i--) {
                if (board[r - height + 1][i].equals("x")) {
                    board[r - height + 1][i] = ".";
                    return i;
                }
            }
        }
        return -1;
    }

    public static String[][] copy() {
        String[][] copy = new String[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }
}
