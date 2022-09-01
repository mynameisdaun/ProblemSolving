package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11053_가장_긴_증가하는_부분_수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = new int[n + 1];
        for (int i = 0; i < input.length; i++) {
            numbers[i + 1] = input[i];
        }
        int[] memo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(numbers[i]>numbers[j]) {
                    memo[i] = Math.max(memo[i], memo[j]+1);
                    answer = Math.max(memo[i],answer);
                }
            }
        }
        System.out.println(answer);
    }
}
// 3 2 1 4 5 6
// 3 2 1 7 8 9 4 5 6 5
