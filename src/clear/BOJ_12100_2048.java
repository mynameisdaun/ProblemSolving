package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_12100_2048 {
    static int n;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] input = Arrays
                    .stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = input[j];
            }
        }
        dfs(0, board);
        System.out.println(answer);
    }

    public static void dfs(int L, int[][] board) {
        if (L == 5) {
            //check
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(board[i][j], max);
                }
            }
            answer = Math.max(answer, max);
        } else {
            moveUp(L, copyOfBoard(board));
            moveRight(L, copyOfBoard(board));
            moveLeft(L, copyOfBoard(board));
            moveDown(L, copyOfBoard(board));
        }
    }

    public static void moveUp(int L, int[][] board) {
        int[][] copy = copyOfBoard(board);
        for (int col = 0; col < n; col++) {
            boolean[] visited = new boolean[n];
            for (int row = 0; row < n; row++) {
                int index = row;
                if (copy[row][col] != 0) {
                    while (index - 1 >= 0 && copy[index - 1][col] == 0) {
                        index--;
                    }
                    if (copy[index][col] == 0) {
                        copy[index][col] = copy[row][col];
                        copy[row][col] = 0;
                    }
                    if (index - 1 >= 0
                            && copy[index - 1][col] == copy[index][col]
                            && !visited[index - 1]
                    ) {
                        copy[index - 1][col] *= 2;
                        copy[index][col] = 0;
                        visited[index - 1] = true;
                    }
                }
            }
        }
        //print(copy);
        dfs(L + 1, copy);
    }

    public static void moveDown(int L, int[][] board) {
        int[][] copy = copyOfBoard(board);
        for (int col = 0; col < n; col++) {
            boolean[] visited = new boolean[n];
            for (int row = n - 1; row >= 0; row--) {
                int index = row;
                if (copy[row][col] != 0) {
                    while (index + 1 < n && copy[index + 1][col] == 0) {
                        index++;
                    }
                    if (copy[index][col] == 0) {
                        copy[index][col] = copy[row][col];
                        copy[row][col] = 0;
                    }
                    if (index + 1 < n
                            && copy[index + 1][col] == copy[index][col]
                            && !visited[index + 1]
                    ) {
                        copy[index + 1][col] *= 2;
                        copy[index][col] = 0;
                        visited[index + 1] = true;
                    }
                }
            }
        }
        dfs(L + 1, copy);
    }


    public static void moveLeft(int L, int[][] board) {
        int[][] copy = copyOfBoard(board);
        for (int row = 0; row < n; row++) {
            boolean[] visited = new boolean[n];
            for (int col = 0; col < n; col++) {
                int index = col;
                if (copy[row][col] != 0) {
                    while (index - 1 >= 0 && copy[row][index - 1] == 0) {
                        index--;
                    }
                    if (copy[row][index] == 0) {
                        copy[row][index] = copy[row][col];
                        copy[row][col] = 0;
                    }
                    if (index - 1 >= 0
                            && copy[row][index - 1] == copy[row][index]
                            && !visited[index - 1]
                    ) {
                        copy[row][index - 1] *= 2;
                        copy[row][index] = 0;
                        visited[index - 1] = true;
                    }
                }
            }
        }
        dfs(L + 1, copy);
    }

    public static void moveRight(int L, int[][] board) {
        int[][] copy = copyOfBoard(board);
        for (int row = 0; row < n; row++) {
            boolean[] visited = new boolean[n];
            for (int col = n - 1; col >= 0; col--) {
                int index = col;
                if (copy[row][col] != 0) {
                    while (index + 1 < n && copy[row][index + 1] == 0) {
                        index++;
                    }
                    if (copy[row][index] == 0) {
                        copy[row][index] = copy[row][col];
                        copy[row][col] = 0;
                    }
                    if (index + 1 < n
                            && copy[row][index + 1] == copy[row][index]
                            && !visited[index + 1]
                    ) {
                        copy[row][index + 1] *= 2;
                        copy[row][index] = 0;
                        visited[index + 1] = true;
                    }
                }
            }
        }
        dfs(L + 1, copy);
    }


    public static void print(int[][] board) {
        System.out.println("======= start ======");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] copyOfBoard(int[][] board) {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }

}
