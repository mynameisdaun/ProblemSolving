package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static java.lang.Integer.parseInt;

public class 트리지름_날먹 {

    static int N, max, INF = Integer.MAX_VALUE;
    static List<List<Node>> board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());
        board = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            board.add(new ArrayList<Node>());
        }

        for (int i = 1; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int s = parseInt(input[0]);
            int e = parseInt(input[1]);
            int d = parseInt(input[2]);
            board.get(s).add(new Node(e, d));
            board.get(e).add(new Node(s, d));
        }

        dijkstra(1);
        System.out.println(dijkstra(max));
    }

    static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.distance;
            int now = node.index;
            if (distance[now] < dist) {
                continue;
            }
            for (int i = 0; i < board.get(now).size(); i++) {
                int cost = distance[now] + board.get(now).get(i).distance;
                if (cost < distance[board.get(now).get(i).index]) {
                    distance[board.get(now).get(i).index] = cost;
                    pq.offer(new Node(board.get(now).get(i).index, cost));
                }
            }
        }
        int answer = -1;
        for (int i = 1; i <= N; i++) {
            if (distance[i] != INF && distance[i] > answer) {
                answer = distance[i];
                max = i;
            }
        }
        return answer;
    }

    static class Node {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}

