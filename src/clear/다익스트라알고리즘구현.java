package clear;

import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 다익스트라알고리즘구현 {

    public static void main(String[] args) throws IOException {
        int n = 6;  // node 수/ vertex 수
        int start = 1; //시작노드번호
        int[][] input = {
                {1, 2, 2},
                {1, 3, 5},
                {1, 4, 1},
                {2, 3, 3},
                {2, 4, 2},
                {3, 2, 3},
                {3, 6, 5},
                {4, 3, 3},
                {4, 5, 1},
                {5, 3, 1},
                {5, 6, 2}
        };
        int[][] graph = new int[n+1][n+1];
        for(int i = 0 ; i < graph.length ; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        for(int i = 0 ; i < input.length; i ++) {
            int x = input[i][0];
            int y = input[i][1];
            int d = input[i][2];
            graph[x][y]=d;
            graph[y][x]=d;
        }
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n+1];

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(start,0));

        distance[start]=0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();
            if(visited[now]) {
                continue;
            }
            visited[now]=true;
            for(int i = 1 ; i <= n ; i ++) {
                if(graph[now][i] < Integer.MAX_VALUE) {
                    distance[i] = Math.min(distance[i],dist+graph[now][i]);
                    pq.offer(new Node(i, dist+graph[now][i]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        private int index;
        private int distance;

        public Node(final int index, final int distance) {
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
        public int compareTo(final Node o) {
            return this.distance-o.distance;
        }
    }
}
