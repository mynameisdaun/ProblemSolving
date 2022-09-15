package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcase = Integer.parseInt(br.readLine());

        while (tcase-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            boolean[][] board = new boolean[n + 1][n + 1];

            int[] time = new int[n + 1];
            int[] construct = new int[n + 1];
            boolean[] visited = new boolean[n + 1];

            input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                construct[i + 1] = Integer.parseInt(input[i]);
            }

            int[] degree = new int[n + 1];
            for (int i = 0; i < k; i++) {
                input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                board[start][end] = true;
                degree[end]++;
            }

            int target = Integer.parseInt(br.readLine());

            Queue<Node> queue = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                if (degree[i] == 0) {
                    queue.offer(new Node(i, 1));
                }
            }

            while (!queue.isEmpty()) {
                Node now = queue.poll();
                //System.out.println("now: "+now.index+" level: "+now.level);
                if (now.index == target) {
                    int answer = construct[target];
                    for (int i = 1; i <= now.level - 1; i++) {
                        answer += time[i];
                    }
                    System.out.println(answer);
                    break;
                }

                visited[now.index] = true;
                time[now.level] = Math.max(time[now.level], construct[now.index]);

                for (int i = 1; i <= n; i++) {
                    if (board[now.index][i]) {
                        degree[i]--;
                        if(degree[i]==0 && !visited[i]) {
                            queue.offer(new Node(i, now.level + 1));
                        }
                    }
                }
            }
        }
    }

    static class Node {
        private int index;
        private int level;

        public Node(int index, int level) {
            this.index = index;
            this.level = level;
        }
    }
}
/*
1
2 1
1000 1
1 2
1

1
4 4
1000 1 10000000 9
1 2
1 3
2 4
3 4
4

1
2 1
100 10
2 1
1

1
5 5
10 1 100 10 5000
1 2
1 3
2 4
3 4
5 4
4
 */
