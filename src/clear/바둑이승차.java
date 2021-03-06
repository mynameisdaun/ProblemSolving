package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 바둑이승차 {

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        바둑이승차 main = new 바둑이승차();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int total = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        main.DFS(0, 0, N, arr, total);
        System.out.println(max);
    }

    void DFS(int L, int S, int N, int[] arr, int total) {
        if (S > total) return;
        if (L == N) {
            if (S > max) max = S;
        } else {
            DFS(L + 1, S + arr[L], N, arr, total);
            DFS(L + 1, S, N, arr, total);
        }
    }
}
