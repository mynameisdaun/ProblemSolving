package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4386_별자리만들기 {

    static int[] parent;

    public static void union(double a, double b) {
        if (a < b)
            parent[(int) b] = (int) a;
        else
            parent[(int) a] = (int) b;
    }

    public static int find(double i) {
        if (parent[(int) i] == i)
            return (int) i;
        return parent[(int) i] = find(parent[(int) i]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.d.intValue() - b.d.intValue());
        Double[][] board = new Double[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
            double a = Double.parseDouble(tokens.nextToken());
            double b = Double.parseDouble(tokens.nextToken());
            board[i] = new Double[]{a, b};

            for (int j = i - 1; j >= 0; j--) {
                Double[] d = board[j];
                double e = d[0];
                double f = d[1];
                pq.add(new Node(i, j, Math.round(Math.sqrt(Math.pow(e - a, 2) + Math.pow(f - b, 2)) * 100) / 100.0));
            }
        }

        parent = new int[n];
        for (int j = 0; j < n; j++) {
            parent[j] = j;
        }
        double answer = 0.00;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int s = now.s;
            int e = now.e;
            Double d = now.d;
            int s_parent = find(s);
            int e_parent = find(e);
            if (s_parent != e_parent) {
                answer += d;
                union(s_parent, e_parent);
            }
        }
        System.out.println(answer);
    }

    static class Node {
        private int s;
        private int e;
        private Double d;

        public Node(int s, int e, double d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }
    }
}
