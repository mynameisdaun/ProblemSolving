package challenging;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int c = input[1];;
        int[] houses = new int[n];
        for(int i = 0 ; i < n ; i++) {
            houses[i]=Integer.parseInt(br.readLine());
        }///
        Arrays.sort(houses);;
        int min = 1;;
        int max = houses[n-1];;
        int answer = 0;;
        while(min <= max) {
            int mid = (min + max) / 2;
            int start = 0;
            int end = 1;
            int count = 1;
            while(end<n&&count<c) {
                if(houses[end]-houses[start] >= mid) {
                    start=end;
                    count++;
                }
                end++;
            }
            if(count==c) {
                answer = Math.max(answer, mid);
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
