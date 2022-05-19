package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 두용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long[] input = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong).boxed().toArray(Long[]::new);
        Arrays.sort(input, (a,b)->a.compareTo(b));

        int start = 0;
        int end = input.length-1;
        long answer = Long.MAX_VALUE;
        long a = 0;
        long b = 0;
        //-99 -2 -1 4 98
        while(start<end) {
            if(Math.abs(input[start]+input[end]) < answer) {
                answer = Math.abs(input[start]+input[end]);
                a = input[start];
                b = input[end];
            }
            if(input[start]+input[end]>0) {
                end--;
            }else {
                start++;
            }
        }
        System.out.println(a);
        System.out.println(b);
        //
        // -99 -2 -1 4 98
        // -101 -100 -95 -1


    }
}
