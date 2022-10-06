package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BOJ_2573_빙산 {

    static int row, col, board[][], dx[] = {1, -1, 0, 0}, dy[] = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        row = Integer.parseInt(input[0]);
        col = Integer.parseInt(input[1]);
        List<int[]> ices = new ArrayList<>();
        board = new int[row][col];
        for (int i = 0; i < row; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.parseInt(input[j]);
                if (board[i][j] > 0) {
                    ices.add(new int[]{i, j});
                }
            }
        }
        int time = 0;
        while (true) {
            if (ices.isEmpty()) {
                System.out.println(0);
                return;
            }
            int total = ices.size();
            int[] start = ices.get(0);
            boolean[][] visited = new boolean[row][col];
            Queue<int[]> queue = new LinkedList<>();
            visited[start[0]][start[1]] = true;
            queue.add(start);
            int cnt = 0;
            while (!queue.isEmpty()) {
                cnt++;
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col && !visited[nx][ny] && board[nx][ny] > 0) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            if (cnt != total) {
                System.out.println(time);
                return;
            }
            List<int[]> newIces = new ArrayList<>();
            visited = new boolean[row][col];
            for (int[] ice : ices) {
                int x = ice[0];
                int y = ice[1];
                visited[x][y] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col && !visited[nx][ny] && board[nx][ny] == 0) {
                        board[x][y]--;
                    }
                }
                if (board[x][y] > 0) {
                    newIces.add(ice);
                } else {
                    board[x][y] = 0;
                }
            }
            ices.clear();
            ices.addAll(newIces);
            time++;
        }
    }
}
/*
5 5
0 0 0 0 0
0 9 9 9 0
0 8 1 2 0
0 9 9 9 0
0 0 0 0 0



5 5
0 0 0 0 0
0 10 10 0 0
0 0 5 0 0
0 0 10 10 0
0 0 0 0 0

5 5
0 0 0 0 0
0 9 9 0 0
0 0 9 0 0
0 0 9 9 0
0 0 0 0 0

5 5
0 0 0 0 0
0 9 9 0 0
0 0 0 0 0
0 0 9 9 0
0 0 0 0 0


4 4
0 0 0 0
0 9 0 0
0 0 0 0
0 0 0 0

4 4
0 0 0 0
0 9 0 0
0 0 0 0
0 0 0 0


4 4
0 0 0 0
0 2 0 0
0 1 1 0
0 0 0 0

4 4
0 0 0 0
0 2 2 0
0 0 0 0
0 0 0 0

4 4
0 0 0 0
0 2 0 0
0 0 2 0
0 0 0 0

4 4
0 0 0 0
0 2 0 0
0 0 1 0
0 0 0 0
 */
