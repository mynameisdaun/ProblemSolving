package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2467_두용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] liquids = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int A = 0;
        int B = 0;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int left = i;

            int start = i + 1;
            int end = n - 1;


            while (start <= end) {
                int mid = (start + end) / 2;
                int tmp = liquids[left] + liquids[mid];
                //System.out.println("left : " + left + " start: " + start + " end: " + end + "" + " mid: " + mid + " tmp: " + tmp);
                if (tmp == 0) {
                    System.out.print(liquids[left] + " " + liquids[mid]);
                    return;
                }
                if (tmp > 0) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
                if (Math.abs(tmp) < answer) {
                    A = left;
                    B = mid;
                    answer = Math.abs(tmp);
                }
            }
        }

        System.out.println(liquids[A]+" "+liquids[B]);
    }
}

