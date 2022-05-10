package clear;

import java.io.IOException;
import java.util.Arrays;

public class 곱하기혹은더하기 {
    private static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        //String s = "02984";
        String s = "567";;
//313
        if(s.length()==1) {
            System.out.println(s);
            return;
        }
        int[] arr = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray();
        int answer = arr[0];
        for(int i = 1 ; i < arr.length ; i++) {
            if(answer<=1||arr[i]<=1) {
                answer += arr[i];
                continue;
            }
            answer *= arr[i];
        }
        System.out.println(answer);
    }
}
