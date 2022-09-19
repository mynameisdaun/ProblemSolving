package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static java.lang.Integer.parseInt;

public class Main {

    static int N, M, start, end, distance[];
    static List<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());
        M = parseInt(br.readLine());
        distance = new int[1001];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int s = parseInt(input[0]), e = parseInt(input[1]), w = parseInt(input[2]);
            graph.get(s).add(new Node(e, w));

        }
        String[] input = br.readLine().split(" ");
        start = parseInt(input[0]);
        end = parseInt(input[1]);

        PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)->a.distance-b.distance);

        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int dist = node.distance;
            int now = node.end;

            if (distance[now] < dist) {
                continue;
            }

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = distance[now] + graph.get(now).get(i).distance;

                if (cost < distance[graph.get(now).get(i).end]) {
                    distance[graph.get(now).get(i).end] = cost;
                    pq.offer(new Node(graph.get(now).get(i).end, cost));
                }
            }
        }

        System.out.println(distance[end]);


    }

    public static class Node {
        public int end;
        public int distance;

        public Node(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }
    }

}

