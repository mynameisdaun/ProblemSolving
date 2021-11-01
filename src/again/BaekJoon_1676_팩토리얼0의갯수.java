package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_1676_팩토리얼0의갯수 {

    static long[] dp = new long[501];
    static int answer = 0 ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0 ;

        while(N >= 5){
            count += N/5;
            N /=5;
        }

        System.out.println(count);
    }

}



