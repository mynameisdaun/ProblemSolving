package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_소여물 {
    private static List<ArrayList<Edge>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int d = Integer.parseInt(input[2]);
            setEdge(s, e, d);
            setEdge(e, s, d);
        }
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            int dist = poll.getD();
            int now = poll.getE();

            if (distance[now] < dist) {
                continue;
            }
            for (int i = 0; i < list.get(now).size(); i++) {
                int cost = distance[now] + list.get(now).get(i).getD();
                int next = list.get(now).get(i).getE();
                if (cost < distance[next]) {
                    distance[next] = cost;
                    pq.offer(new Edge(next, cost));
                }
            }
        }
        System.out.println(distance[n]);
    }

    private static void setEdge(int s, int e, int d) {
        ArrayList<Edge> edges = list.get(s);
        Edge edge = new Edge(e, d);
        if (edges.contains(edge)) {
            int index = 0;
            for (index = 0; index < edges.size(); index++) {
                if (edges.get(index).equals(edge)) break;
            }
            if (edges.get(index).getD() > d) {
                edges.remove(index);
                edges.add(edge);
            }
        } else {
            edges.add(edge);
        }
    }

    static class Edge implements Comparable<Edge> {
        private int e;
        private int d;

        public Edge(int e, int d) {
            this.e = e;
            this.d = d;
        }

        public int getE() {
            return e;
        }

        public int getD() {
            return d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            return e == edge.e;
        }

        @Override
        public int hashCode() {
            return e;
        }

        @Override
        public int compareTo(Edge o) {
            return this.d-o.d;
        }
    }
}
