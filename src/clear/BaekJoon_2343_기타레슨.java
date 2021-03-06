package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_2343_기타레슨 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long start = Arrays.stream(arr).max().getAsInt();
        long answer = 0;
        long end = Arrays.stream(arr).sum();
        while(start <= end) {
            long mid = (start + end) / 2;
            long count = 1;
            long volume = mid;
            for(int i = 0 ; i < N ; i++) {
                if(volume - arr[i] < 0) {
                    ++count;
                    volume = mid - arr[i];
                }else {
                    volume -= arr[i];
                }
            }
            if(count > M) {
                start = mid + 1;
            } else {
                answer = mid;
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
