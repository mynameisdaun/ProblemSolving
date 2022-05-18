package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 서류 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            int answer =0;
            int N = Integer.parseInt(br.readLine());
            int[][] input = new int[N][2];
            for(int i = 0 ; i < N ; i++) {
                input[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                //서류, 면접
            }
            Arrays.sort(input, (a,b) -> a[1]!=b[1] ? a[1]-b[1] : a[0]-b[0]);
            int paper = N+1;
            for(int i = 0 ; i < input.length ; i++) {
                if(input[i][0]<paper) {
                    answer++;
                    paper = input[i][0];
                }
            }
            System.out.println(answer);
            //4   1  ++
            //3   2  ++
            //2   3  ++
            //1   4  ++
            //5   5
        }
    }
}
