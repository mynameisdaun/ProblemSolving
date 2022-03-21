package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input1[0];
        int M = input1[1];
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);


        long start = 0 ;
        long end = arr[arr.length-1];
        //덜잘라야되는경우
        while(start <= end) {
            long mid = (start + end) / 2;
            long 나무길이 = Arrays.stream(arr).filter(a -> a > mid).mapToLong(a -> a - mid).sum();
            if(M <= 나무길이) {
                start = mid + 1;
                continue;
            }
            end = mid - 1;
            continue;
        }
        System.out.println(end);
    }
}
