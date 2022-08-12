package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BaekJoon_1655_가운데말해요 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>((a, b) -> -Integer.compare(a, b));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (i % 2 != 0) {
                maxPQ.offer(number);
            } else {
                minPQ.offer(number);
            }
            if(!maxPQ.isEmpty() && !minPQ.isEmpty() && maxPQ.peek() >  minPQ.peek()) {
                maxPQ.offer(minPQ.poll());
                minPQ.offer(maxPQ.poll());
            }
            sb.append(maxPQ.peek()+" ");
        }
        System.out.println(sb.toString());
    }

}

