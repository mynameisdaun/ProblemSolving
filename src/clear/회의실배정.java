package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 회의실배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N][2];
        for(int i = 0 ; i < N ; i++) {
            input[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(input, (a,b)-> a[1] != b[1] ? a[1]-b[1] : a[0]-b[0]);
        int end = -1;
        int answer = 0 ;
        for(int i = 0 ; i < input.length ; i ++) {
            if(input[i][0] >= end) {
                answer++;
                end = input[i][1];
            }
        }
        System.out.println(answer);
    }

}
