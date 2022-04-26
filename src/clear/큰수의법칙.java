package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 5;
        int M = 8;
        int K = 3;
        int[] arr = {2, 4, 5, 4, 6};
        Arrays.sort(arr);
        int first = arr[N-1];
        int second = arr[N-2];
        int answer = 0;
        int count = M / (K+1);
        answer += ((first*K)+second) * count;
        answer += first * (M  % (K+1));
        System.out.println(answer);
    }
}

