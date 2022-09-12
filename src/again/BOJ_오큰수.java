package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_오큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (n == 1) {
            System.out.println(-1);
            return;
        }

        int[] memo = new int[n];
        int max = numbers[n - 1];
        memo[n - 1] = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (numbers[i] < max) {
                memo[i] = max;
            } else {
                memo[i] = -1;
                max = numbers[i];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(memo[i] + " ");
        }
        System.out.println();
    }
}
