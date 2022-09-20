package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.parseInt;

public class BOJ_17071_숨바꼭질 {
    static int INF = 500001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int a = parseInt(input[0]);
        int b = parseInt(input[1]);

        int[] sister = new int[INF];
        Arrays.fill(sister, INF);

        sister[b] = 0;
        int idx = 1, pos = b;
        while (pos + idx < INF) {
            sister[pos + idx] = idx;
            pos += idx++;
        }
        int max = idx;

        boolean[] visited = new boolean[INF];
        int min = INF;
        visited[a] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(a, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
//            if(node.l == max) {
//                break;
//            }
            System.out.println(" index: " + node.index + " level: " + node.l + " sister: " + sister[node.l]);

            if (sister[node.index] != INF && sister[node.index] > node.l && (sister[node.index] - node.l) % 2 == 0) {
                min = Math.min(min, sister[node.index]);
            }

            if (sister[node.index] == node.l || node.l >= min) {
                System.out.println(Math.min(node.l, min));
                return;
            }

            int nl = node.l + 1;

            if (node.index * 2 < INF && !visited[node.index * 2]) {
                visited[node.index * 2] = true;
                queue.offer(new Node(node.index * 2, nl));
            }
            if (node.index + 1 < INF && !visited[node.index + 1]) {
                visited[node.index + 1] = true;
                queue.offer(new Node(node.index + 1, nl));
            }
            if (node.index - 1 >= 0 && !visited[node.index - 1]) {
                visited[node.index - 1] = true;
                queue.offer(new Node(node.index - 1, nl));
            }
        }
        System.out.println(-1);
    }

    static class Node {
        private int index;
        private int l;

        public Node(int index, int l) {
            this.index = index;
            this.l = l;
        }
    }

}

