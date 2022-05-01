package clear;

import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 전보 {
    private static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        int N = 3;
        int M = 2;
        int C = 1;
        int[][] arr = {
                {1, 2, 4},
                {1, 3, 2}
        };
        int[][] board = new int[N+1][N+1];
        int[] distance = new int[N+1];

        for(int i = 0 ; i < board.length ; i++) {
            Arrays.fill(board[i], INF);
        }

        for(int i = 0 ; i < arr.length ; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            int d = arr[i][2];
            board[x][y]=d;
        }


        Arrays.fill(distance, INF);
        boolean[] visited = new boolean[N+1];

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(C,0));

        distance[C]=0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int d = node.getDistance();
            int now = node.getIndex();
            if(visited[now]) {
                continue;
            }
            visited[now]=true;
            for(int i = 1 ; i <=N ; i++) {
                distance[i] = Math.min(distance[i], d+board[now][i]);
                pq.offer(new Node(i, d+board[now][i]));
            }
        }




    }

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
            return this.getDistance()-o.getDistance();
        }
    }
}
