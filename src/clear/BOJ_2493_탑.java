package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_2493_탑 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] memo = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                int index = stack.pop();
                memo[index] = i + 1;
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(memo[i]+" ");
        }
    }
}

//6 9 3 1 4
