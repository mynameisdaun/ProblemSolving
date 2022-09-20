package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.parseInt;

public class BOJ_숨바꼭질3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int a = parseInt(input[0]);
        int b = parseInt(input[1]);
        if (b <= a) {
            System.out.println(a - b);
            return;
        }

        boolean[] visited = new boolean[100001];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(a, 0));
        visited[a] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.index == b) {
                System.out.println(node.l);
                return;
            }
            if (node.index * 2 < 100001 && !visited[node.index * 2]) {
                visited[node.index * 2] = true;
                queue.offer(new Node(node.index * 2, node.l + 1));
            }
            if (node.index + 1 < 100001 && !visited[node.index + 1]) {
                visited[node.index + 1] = true;
                queue.offer(new Node(node.index + 1, node.l + 1));
            }
            if (node.index - 1 >= 0 && !visited[node.index - 1]) {
                visited[node.index - 1] = true;
                queue.offer(new Node(node.index - 1, node.l + 1));
            }
        }
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

