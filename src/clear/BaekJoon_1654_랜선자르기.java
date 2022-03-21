package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K, N, max = Integer.MIN_VALUE;
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        K = input1[0];
        N = input1[1];
        int[] arr = new int[K];

        for(int i = 0 ; i < K ; i ++) {
            arr[i]=Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long start = 1;
        long end = max;
        long answer = 0 ;

        while(start <= end) {
            long mid = (start + end) / 2;
            //System.out.println("====mid : "+mid+"=====");
            int count = 0;
            for(int i = 0 ; i < K ; i++) {
                //System.out.println(arr[i] / mid);
                count += Math.floor(arr[i] / mid);
            }
            if(count >= N) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
