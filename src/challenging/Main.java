package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};

        int k = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[1]);
        int col = Integer.parseInt(input[0]);
        int[][] board = new int[row][col];

        for (int i = 0; i < row; i++) {
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        if(row==1&&col==1&&board[0][0]==1) {
            System.out.println(-1);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[k+1][row][col];
        visited[0][0][0] = true;
        //k, x, y, d
        queue.offer(new int[]{0, 0, 0, 0});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int currK = node[0];
            int currX = node[1];
            int currY = node[2];
            int currD = node[3];
            if(currX==row-1&&currY==col-1) {
                System.out.println(currD);
                return;
            }
            //말처럼 더 움직일 수 있을때
            if (currK < k) {
                for (int i = 0; i < 8; i++) {
                    int nx = currX + hx[i];
                    int ny = currY + hy[i];
                    int nk = currK + 1;
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col && !visited[nk][nx][ny] && board[nx][ny] != 1) {
                        visited[nk][nx][ny]=true;
                        queue.offer(new int[]{nk, nx, ny, currD + 1});
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && !visited[currK][nx][ny] && board[nx][ny] != 1) {
                    visited[currK][nx][ny]=true;
                    queue.offer(new int[]{currK, nx, ny, currD + 1});
                }
            }
        }
        System.out.println(-1);
    }
}
/*
0
2 2
0 1
1 0
-> -1

0
2 2
0 0
1 0
-> 2

0
2 3
0 1
1 1
1 0
-> -1

1
2 3
0 1
1 1
1 0
-> 1

2
2 6
0 1
1 1
0 0
0 1
1 1
1 0
->4
 */
