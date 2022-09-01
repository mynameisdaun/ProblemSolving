package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_1753_최단경로 {
    static int INF = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int vertex = input[0];
        int edge = input[1];
        int start = Integer.parseInt(br.readLine());

        List<ArrayList<Node>> board = new ArrayList<>();
        for(int i = 0 ; i <= vertex ; i++) {
            board.add(new ArrayList<Node>());
        }

        for(int i = 0 ; i < edge ; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int s = input[0];
            int e = input[1];
            int w = input[2];
            board.get(s).add(new Node(e, w));
        }

        int[] distance = new int[vertex+1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()) {
            Node poll = pq.poll();
            int now = poll.getIndex();
            int dist = poll.getDistance();

            if(distance[now] < dist) continue;

            for(int i = 0 ; i < board.get(now).size() ; i++) {
                int cost = distance[now] + board.get(now).get(i).getDistance();
                if(cost < distance[board.get(now).get(i).getIndex()]) {
                    distance[board.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(board.get(now).get(i).getIndex(), cost));
                }
            }
        }
        for(int i = 1 ; i <= vertex ; i++) {
            if(distance[i]>=INF) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }

    static class Node implements Comparable<Node> {
        private int index;
        private int distance;

        public Node(int end, int value) {
            this.index = end;
            this.distance = value;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}
