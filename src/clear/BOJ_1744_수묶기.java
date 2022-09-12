package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1744_수묶기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positive = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        int zero = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) zero++;
            else if (num > 0) positive.add(num);
            else negative.add(num);
        }
        //양수 두개 더하기
        while (positive.size() >= 2) {
            int a = positive.poll();
            int b = positive.poll();
            if (a == 1 || b == 1) {
                answer += (a + b);
            } else {
                answer += (a * b);
            }
        }
        if(!positive.isEmpty()) {
            answer += positive.poll();
        }

        while(negative.size() >= 2) {
            answer += (negative.poll() * negative.poll());
        }

        if(!negative.isEmpty()) {
            if(zero < 1) {
                answer += negative.poll();
            }
        }
        System.out.println(answer);
    }
}

//3 2 1 -1
