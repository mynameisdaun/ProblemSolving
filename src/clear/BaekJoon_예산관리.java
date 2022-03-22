package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_예산관리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int budget = Integer.parseInt(br.readLine());

        long end = Long.MIN_VALUE;
        long answer = 0;

        for (int num : arr) {

            end = Math.max(end, num);
        }
        long start = 0;

        while(start <= end) {
            long 상한액 = (start + end) / 2;
            long 전체예산 = 0;
            for(int i = 0 ; i < arr.length ; i++) {
                if(arr[i] <= 상한액) 전체예산 += arr[i];
                else {
                    전체예산 += 상한액;
                }
            }

            if(전체예산 <= budget) {
                answer = 상한액;
                start = 상한액 + 1;
            } else {
                end = 상한액 - 1;
            }
        }
        System.out.println(answer);
    }
}
