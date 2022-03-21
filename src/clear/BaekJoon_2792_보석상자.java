package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];
        int[] arr = new int[M];
        int end = Integer.MIN_VALUE;
        for(int i = 0 ; i < M ; i ++) {
            arr[i]=Integer.parseInt(br.readLine());
            end = Math.max(end, arr[i]);
        }

        int start  = 1;
        int answer = 0;

        while(start <= end) {
            int mid = (start + end) / 2;
            int 학생수 = 0 ;
            for(int i = 0 ; i < arr.length ; i++) {
                학생수 += Math.ceil((double)arr[i] / mid);
            }

            if(학생수 > N) {
                start = mid + 1;
            } else {
                answer = mid;
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
