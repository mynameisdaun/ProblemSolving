package clear;

import java.io.IOException;

public class 간단한DP {

    public static void main(String[] args) throws IOException {
        //5로나눠지면 5로 나눈다
        //3으로 나눠지면 3으로 나눈다
        //2로나눠지면 2로나눈다
        //1을뺀다
        // n = 26 answer = 3
        int n = 26;
        int[] arr = new int[27];
        for(int i = 2; i <= n; i++) {
            //1뺀경우
            arr[i]=arr[i-1]+1;
            if(i%2 == 0) {
                arr[i] = Math.min(arr[i/2] + 1, arr[i]);
            }
            if(i%5 == 0) {
                arr[i] = Math.min(arr[i/5] + 1, arr[i]);
            }
            if(i%3 ==0) {
                arr[i] = Math.min(arr[i/3]+1, arr[i]);
            }
        }
        System.out.println(arr[n]);
    }
}
