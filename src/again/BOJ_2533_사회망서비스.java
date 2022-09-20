package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

public class BOJ_2533_사회망서비스 {
//https://wnwngus.tistory.com/39
    static int N, degree[], answer = MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());
        List<List<Integer>> board = new ArrayList<>();
        degree = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            board.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int s = parseInt(input[0]);
            int e = parseInt(input[1]);
            if (s > e) {
                int tmp = s;
                s = e;
                e = tmp;
            }
            board.get(s).add(e);
            degree[e]++;
        }
        int start = -1;
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                start = i;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        //1번 early
        int tmp = 0;
        queue.offer(new Node(start, true));
        visited[start] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.early) tmp++;
            List<Integer> list = board.get(node.idx);
            for (int i = 0; i < list.size(); i++) {
                if (!visited[list.get(i)]) {
                    visited[list.get(i)] = true;
                    queue.offer(new Node(list.get(i), !node.early));
                }
            }
        }
        answer = Math.min(tmp, N - tmp);

        queue.clear();
        visited = new boolean[N + 1];
        queue.offer(new Node(start, false));
        visited[start] = true;
        tmp = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.early) tmp++;
            List<Integer> list = board.get(node.idx);
            for (int i = 0; i < list.size(); i++) {
                if (!visited[list.get(i)]) {
                    visited[list.get(i)] = true;
                    queue.offer(new Node(list.get(i), !node.early));
                }
            }
        }

        answer = Math.min(answer, tmp);
        answer = Math.min(answer, N - tmp);
        System.out.println(answer);
    }

    static class Node {
        private int idx;
        private boolean early;

        public Node(int idx, boolean early) {
            this.idx = idx;
            this.early = early;
        }
    }
}

