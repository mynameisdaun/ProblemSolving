package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_sudoku {

    static int board[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[10][10];
        List<int[]> zeros = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            String[] input = br.readLine().split("");
            for (int j = 1; j <= 9; j++) {
                board[i][j] = Integer.parseInt(input[j - 1]);
                if (board[i][j] == 0) {
                    zeros.add(new int[]{i, j});
                }
            }
        }

        dfs(zeros, 0);
    }

    static void dfs(List<int[]> zeros, int l) {
        if (l == zeros.size()) {
            answer(board);
            System.exit(0);
        }
        int x = zeros.get(l)[0];
        int y = zeros.get(l)[1];
        List<Integer> possibleNumber = getPossibleNumber(x, y);
        for (int i = 0; i < possibleNumber.size(); i++) {
            board[x][y] = possibleNumber.get(i);
            dfs(zeros, l + 1);
            board[x][y] = 0;
        }
    }

    static void answer(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }


    static List<Integer> getPossibleNumber(int x, int y) {
        List<Integer> list = new ArrayList<>();
        boolean check[] = new boolean[10];
        //가로,세로
        for (int i = 1; i <= 9; i++) {
            if (board[x][i] != 0) check[board[x][i]] = true;
            if (board[i][y] != 0) check[board[i][y]] = true;
        }

        int sx = ((x - 1) / 3) * 3 + 1;
        int sy = ((y - 1) / 3) * 3 + 1;
        for (int i = sx; i <= sx + 2; i++) {
            for (int j = sy; j <= sy + 2; j++) {
                if (board[i][j] != 0) {
                    check[board[i][j]] = true;
                }
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (!check[i]) list.add(i);
        }
        return list;
    }
}
