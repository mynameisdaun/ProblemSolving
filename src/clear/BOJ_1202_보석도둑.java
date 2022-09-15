package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1202_보석도둑 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);


        int[] bags = new int[k];
        Jewel[] jewels = new Jewel[n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            jewels[i] = new Jewel(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(jewels, (a, b) -> a.weight - b.weight);
        Arrays.sort(bags);
        long answer = 0;
        int idx = 0;

        PriorityQueue<Jewel> pq = new PriorityQueue<>((a, b) -> b.value - a.value);
        for (int i = 0; i < k; i++) {
            int bag = bags[i];
            while (true) {
                if (idx >= n) break;
                Jewel jewel = jewels[idx];
                if (jewel.weight > bag) break;
                pq.offer(jewel);
                idx++;
            }
            if(pq.isEmpty()) continue;
            answer += pq.poll().value;
        }
        System.out.println(answer);
    }

    static class Jewel {
        private int weight;
        private int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
