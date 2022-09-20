package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class BOJ_11054_가장긴_바이토닉_부분_수열 {

    static int N, numbers[], leftToRight[], rightToLeft[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());
        numbers = new int[N + 1];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            numbers[i + 1] = Integer.parseInt(input[i]);
        }
        leftToRight = new int[N + 1];
        rightToLeft = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            leftToRight[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    leftToRight[i] = Math.max(leftToRight[i], leftToRight[j] + 1);
                }
            }
        }

        for (int i = N; i >= 1; i--) {
            rightToLeft[i] = 1;
            for (int j = N; j > i; j--) {
                if (numbers[j] < numbers[i]) {
                    rightToLeft[i] = Math.max(rightToLeft[i], rightToLeft[j] + 1);
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, leftToRight[i] + rightToLeft[i] - 1);
        }
        System.out.println(answer);
    }
}

