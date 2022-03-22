package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_6236_용돈관리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input1[0];
        int M = input1[1];
        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;


        for(int i = 0 ; i < N ; i ++) {
            arr[i]=Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int start = max ;
        int end = (int) 1e9;
        int answer = 0;

        while(start <= end) {
            int mid = (start + end) / 2;
            int 잔액 = 0 ;
            int count = 0 ;

            for(int i = 0 ; i < N ; i ++) {
                if(잔액 < arr[i]) {
                    ++count;
                    잔액 = mid - arr[i];
                } else {
                    잔액-=arr[i];
                }
            }

            if(count > M) {
                start = mid + 1;
            } else {
                answer=mid;
                end = mid -1 ;
            }
        }
        System.out.println(answer);
    }
}
