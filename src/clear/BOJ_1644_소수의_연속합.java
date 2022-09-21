package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1644_소수의_연속합 {
    static int max = 4000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= max; i++) {
            if (isPrime[i]) list.add(i);
        }
        int N = list.size();
        list.add(0);

        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = 0;

        while (left <= N && right <= N) {
            if(list.get(left) > target) break;

            if(sum >= target) {
                if(sum == target) answer++;
                sum -= list.get(left++);
            } else {
                sum += list.get(right++);
            }
        }
        System.out.println(answer);
    }
}

