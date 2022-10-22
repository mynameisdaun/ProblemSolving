package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BOJ_게임개발 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] inDegree = new int[n + 1];
        int[] times = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        boolean[][] board = new boolean[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            times[i + 1] = input[0];
            for (int j = 1; j < input.length; j++) {
                if (input[j] == -1) break;
                board[input[j]][i + 1] = true;
                inDegree[i + 1]++;
            }
        }

        //번호, 건물짓는데 걸리는 시간, 이제까지 걸린 시간
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1]+a[2]) - (b[1]+b[2]));
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(new int[]{i, times[i], 0});
                visited[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int vertex = node[0];
            int time = node[1];
            int accumulateTime = node[2];
            map.put(vertex, time + accumulateTime);
            for (int i = 1; i <= n; i++) {
                if (!visited[i]&&board[vertex][i]) {
                    if (--inDegree[i] == 0) {
                        queue.offer(new int[]{i, times[i], time+accumulateTime});
                        visited[i]=true;
                    }
                }
            }
        }
        for (int i = 1; i <= n ; i++) {
            System.out.println(map.get(i));
        }
    }
}
/*
4
100(1) - 1(2) - 3 - 1
103  -----------|

4
100 2 3 4 -1
10 -1
30 4 -1
50 -1

4
100 -1
1 1 -1
3 1 2 4 -1
103 -1

5
100 -1
90 -1
80 -1
70 -1
60 1 -1


5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1

 */


