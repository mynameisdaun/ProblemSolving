package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


public class BOJ_회의실배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> {
            if (a.t == b.t) {
                return a.type.compareTo(b.type);
            }
            return a.t - b.t;
        });

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pq.add(new Node(input[0], "S"));
            pq.add(new Node(input[1], "E"));
        }
        //System.out.println(pq);
        int answer = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            Node lecture = pq.poll();
            //System.out.println(lecture.t+" "+lecture.type);
            if (lecture.type.equals("E")) {
                count--;
            }
            if (lecture.type.equals("S")) {
                count++;
                answer = Math.max(count, answer);
            }
        }
        System.out.println(answer);
    }

    static class Node {
        private int t;
        private String type;

        public Node(int t, String type) {
            this.t = t;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "t=" + t +
                    ", type='" + type + '\'' +
                    '}';
        }
    }


}
