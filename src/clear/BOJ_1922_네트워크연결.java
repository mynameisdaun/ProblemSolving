package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1922_네트워크연결 {

    public static int find(int[] parent, int i) {
        if (i == parent[i])
            return i;
        return find(parent, parent[i]);
    }

    public static void union(int[] parent, int a, int b) {
        int pA = find(parent, a);
        int pB = find(parent, b);
        if (pA < pB) {
            parent[pB] = pA;
            return;
        }
        parent[pA] = pB;
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.weight - b.weight);

        for (int i = 0; i < e; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = input[0];
            int end = input[1];
            int weight = input[2];
            pq.add(new Node(start, end, weight));
        }

        int[] parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }
        int answer = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int a = now.start;
            int b = now.end;
            if (find(parent, a) != find(parent, b)) {
                answer += now.weight;
                union(parent, a, b);
            }
        }
        System.out.println(answer);
    }

    static class Node {
        private int start;
        private int end;
        private int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
