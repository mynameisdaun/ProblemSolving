package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class BOJ_부분합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = parseInt(input[0]), S = parseInt(input[1]);
        int[] numbers = new int[N + 1];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (left <= N && right <= N) {
            if (sum >= S) {
                min = Math.min(min, right - left);
                sum -= numbers[left++];
            } else {
                sum += numbers[right++];
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
