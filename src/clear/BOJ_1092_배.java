package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1092_배 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = input(br)[0], crane[] = input(br), m = input(br)[0], boxes[] = input(br);
        Arrays.sort(crane);
        Arrays.sort(boxes);
        int start = 1;
        int end = m;
        int answer = m;
        if (crane[n - 1] < boxes[m - 1]) {
            System.out.println(-1);
            return;
        }
        while (start < end) {
            int mid = (start + end) / 2;
            boolean find = false;
            for (int i = 1; i <= n; i++) {
                int max = m - 1 - (mid * (i - 1));
                int min = m - (mid * i);
                if (max < 0 || (crane[n - i] >= boxes[max] && min <= 0)) {
                    find = true;
                    break;
                }
                if (crane[n - i] < boxes[max]) {
                    break;
                }
            }
            if (find) {
                end = mid;
                answer = Math.min(answer, mid);
            } else {
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }

    static int[] input(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
