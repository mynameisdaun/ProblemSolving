package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class BaekJoon_18352_특정거리의도시찾기 {
    static class Node implements Comparable<Node>{
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance-o.distance;
        }
    }
    public static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];int M = input[1];int K = input[2];int X = input[3];
        boolean[] visited = new boolean[N+1];
        List<ArrayList<Node>> board = new ArrayList<ArrayList<Node>>();
        int[] distance = new int[N+1];
        for(int i = 0 ; i <= N ; i++) {
            board.add(new ArrayList<Node>());
        }
        for(int i = 0 ; i < M ; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            board.get(input[0]).add(new Node(input[1], 1));
        }
        Arrays.fill(distance, INF);
        search(X, distance, board);
        boolean flag=false;
        for(int i = 1 ; i <=N ;i++) {
            if(distance[i]==K) {
                flag=true;
                System.out.println(i);
            }
        }
        if(!flag) {
            System.out.println(-1);
        }
    }


    public static void search(int start, int[] distance, List<ArrayList<Node>> board) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start]=0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();
            if(distance[now] < dist) continue;
            for(int i = 0 ; i < board.get(now).size(); i++) {
                int cost = distance[now] + board.get(now).get(i).getDistance();
                if(cost < distance[board.get(now).get(i).getIndex()]) {
                    distance[board.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(board.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }
}
