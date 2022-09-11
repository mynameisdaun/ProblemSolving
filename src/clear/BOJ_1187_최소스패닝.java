package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1187_최소스패닝 {

    public static void union(int[] parent, int a, int b) {
        int a_parent = find(parent, a);
        int b_parent = find(parent, b);

        if (a_parent < b_parent)
            parent[b_parent] = a_parent;
        else
            parent[a_parent] = b_parent;
    }

    public static int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v = input[0];
        int e = input[1];
        PriorityQueue<Node> pq = new PriorityQueue<Node>(
                (a, b) -> a.weight - b.weight
        );

        for (int i = 0; i < e; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = input[0];
            int end = input[1];
            int weight = input[2];
            pq.offer(new Node(start, end, weight));
        }

        int[] parents = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }
        int answer = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int start = now.start;
            int end = now.end;
            int weight = now.weight;
            if (find(parents, start) != find(parents, end)) {
                answer += weight;
                union(parents, start, end);
            }
        }
        System.out.println(answer);
    }

    public static class Node {
        public int start;
        public int end;
        public int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
