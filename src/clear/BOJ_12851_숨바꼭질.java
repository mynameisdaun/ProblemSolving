package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.parseInt;

public class BOJ_12851_숨바꼭질 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int a = parseInt(input[0]);
        int b = parseInt(input[1]);

        if (b <= a) {
            System.out.println(a - b);
            System.out.println(1);
            return;
        }

        int INF = b - a;
        int cnt = 0;
        int[] visited = new int[100001];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(a, 0));
        Arrays.fill(visited, INF);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            //System.out.println("INF: "+INF+" index: "+node.index+" level: "+node.l);
            if (node.l > INF) continue;

            if (node.index == b) {
                if (node.l < INF) {
                    cnt = 0;
                    INF = node.l;
                }
                cnt++;
            }
            int next = node.l + 1;
            if (node.index * 2 < 100001 && next <= visited[node.index * 2]) {
                visited[node.index * 2] = next;
                queue.offer(new Node(node.index * 2, next));
            }
            if (node.index + 1 < 100001 && next <= visited[node.index + 1]) {
                visited[node.index + 1] = next;
                queue.offer(new Node(node.index + 1, next));
            }
            if (node.index - 1 >= 0 && next <= visited[node.index - 1]) {
                visited[node.index - 1] = next;
                queue.offer(new Node(node.index - 1, next));
            }
        }
        System.out.println(INF);
        System.out.println(cnt);
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

