package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class BOJ_1647_도시분할계획_프림 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        List<List<int[]>> board = new ArrayList<>();

        int n = parseInt(tokenizer.nextToken());

        for (int i = 0; i <= n; i++) {
            board.add(new ArrayList<>());
        }
        int m = parseInt(tokenizer.nextToken());

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int s = parseInt(tokenizer.nextToken());
            int e = parseInt(tokenizer.nextToken());
            int w = parseInt(tokenizer.nextToken());
            board.get(s).add(new int[]{e, w});
            board.get(e).add(new int[]{s, w});
        }

        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{1, 0});
        int total = 0;
        int max = Integer.MIN_VALUE;

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int e = node[0];
            int w = node[1];
            if (!visited[e]) {
                visited[e] = true;
                total += w;
                max = Math.max(max, w);
                for (int[] next : board.get(e)) {
                    if (!visited[next[0]]) {
                        pq.add(next);
                    }
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) count++;
        }
        if (count == n) {
            System.out.println(total - max);
        } else {
            System.out.println(total);
        }
    }
}


