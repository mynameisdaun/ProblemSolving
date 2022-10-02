package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3079_입국심사 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(tokenizer.nextToken()),
                m = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        long left = 0L;
        long right = max * 1000000000L;
        long answer = Long.MAX_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += (mid / arr[i]);
                if (cnt >= m) break;
            }
            if (cnt >= m) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
/*
2 6
7
10
-> 28

7 10
3
8
3
6
9
2
4
-> 8
 */
