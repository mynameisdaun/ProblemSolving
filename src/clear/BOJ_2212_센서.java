package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_2212_센서 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = input(br)[0];
        int k = input(br)[0];
        int[] arr = input(br);
        int sum = 0;
        Arrays.sort(arr);
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                pq.offer(new Point(arr[i - 1], arr[i]));
                sum += (arr[i] - arr[i - 1]);
            }
        }
        while (!pq.isEmpty() && k-- > 1) {
            sum -= pq.poll().d;
        }
        System.out.println(sum);
    }

    static class Point implements Comparable<Point> {
        private int s;
        private int e;
        private int d;

        public Point(int s, int e) {
            this.s = s;
            this.e = e;
            this.d = e - s;
        }

        @Override
        public int compareTo(Point o) {
            return o.d - this.d;
        }
    }


    static int[] input(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
