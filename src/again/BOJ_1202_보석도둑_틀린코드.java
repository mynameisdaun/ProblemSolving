package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_1202_보석도둑_틀린코드 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        PriorityQueue<Jewel> jewels = new PriorityQueue<>((a, b) -> b.value - a.value);
        int[] bags = new int[k];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            jewels.offer(new Jewel(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        long answer = 0;

        for (int i = 0; i < k; i++) {
            int bag = bags[i];
            List<Jewel> list = new ArrayList<>();
            while (true) {
                if (jewels.isEmpty())
                    break;
                Jewel jewel = jewels.poll();
                if (jewel.weight > bag) {
                    list.add(jewel);
                } else {
                    answer += jewel.value;
                    break;
                }
            }
            jewels.addAll(list);
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
