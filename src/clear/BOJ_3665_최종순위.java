package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_3665_최종순위 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcase = Integer.parseInt(br.readLine());
        while (tcase-- > 0) {
            boolean UNCERTAIN = false;
            int n = Integer.parseInt(br.readLine());
            int[] degree = new int[n + 1];
            boolean[][] board = new boolean[n + 1][n + 1];
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    board[input[i]][input[j]] = true;
                    degree[input[j]]++;
                }
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                input = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                if(board[input[0]][input[1]]) {
                    board[input[0]][input[1]] = false;
                    board[input[1]][input[0]] = true;
                    degree[input[1]]--;
                    degree[input[0]]++;
                } else  {
                    board[input[0]][input[1]] = true;
                    board[input[1]][input[0]] = false;
                    degree[input[0]]--;
                    degree[input[1]]++;
                }


            }

            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> result = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                if (degree[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                Integer now = queue.poll();
                if(!queue.isEmpty()) {
                    UNCERTAIN = true;
                    break;
                }

                result.offer(now);
                for(int i = 1 ; i <= n ; i++) {
                    if(board[now][i]) {
                        degree[i]--;
                    }
                }

                for(int i = 1 ; i <= n ; i++) {
                    if(degree[i]==0&&!result.contains(i)){
                        queue.offer(i);
                    }
                }
            }

            if (UNCERTAIN) {
                System.out.println("UNCERTAIN");
                continue;
            }

            if (result.size() < n) {
                System.out.println("IMPOSSIBLE");
                continue;
            }

            while(!result.isEmpty()) {
                System.out.print(result.poll()+" ");
            }
            System.out.println();
        }
    }
}

