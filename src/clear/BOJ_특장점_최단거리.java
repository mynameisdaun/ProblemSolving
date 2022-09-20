package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static java.lang.Integer.parseInt;

public class BOJ_특장점_최단거리 {

    static int N, E, V1, V2, INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = parseInt(input[0]);
        E = parseInt(input[1]);

        List<List<Node>> board = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            board.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int s = parseInt(input[0]), e = parseInt(input[1]), d = parseInt(input[2]);
            board.get(s).add(new Node(e, d));
            board.get(e).add(new Node(s, d));
        }
        input = br.readLine().split(" ");
        V1 = parseInt(input[0]);
        V2 = parseInt(input[1]);

        int[] check = {1, V1, V2, N};
        int[][] save = new int[check.length][check.length];

        for (int c = 0; c < check.length; c++) {
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
            int[] distance = new int[N + 1];
            Arrays.fill(distance, INF);
            distance[check[c]] = 0;
            pq.offer(new Node(check[c], 0));
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
            for (int i = 0; i < check.length; i++) {
                save[c][i] = distance[check[i]];
            }
        }
        int answer = INF;
        if (save[0][1] != INF && save[1][2] != INF && save[2][3] != INF) {
            answer = Math.min(answer, save[0][1] + save[1][2] + save[2][3]);
        }
        if (save[0][2] != INF && save[2][1] != INF && save[1][3] != INF) {
            answer = Math.min(answer, save[0][2] + save[2][1] + save[1][3]);
        }
        System.out.println(answer == INF ? -1 : answer);
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

/*
10 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3

800 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3
* */
