package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ_10610_30 {
    static int INF = 1_000_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        if(N.indexOf('0') < 0) {
            System.out.println("-1");
            return;
        }
        int count = 0;

        for(int i = 0 ; i < N.length() ; i++) {
            if(Character.getNumericValue( N.charAt(i)) == 0) {
                count++;
            }
        }
        N = N.replace("0","");
        int sum = Arrays.stream(N.split("")).mapToInt(Integer::parseInt).sum();
        if(sum % 3 != 0) {
            System.out.println("-1");
            return;
        }
        for (int i = 0; i < count; i++) {
            N+="0";
        }
        System.out.println(
                Arrays.stream(N.split(""))
                        .sorted((a,b)->Integer.parseInt(b)-Integer.parseInt(a))
                        .collect(Collectors.joining())
        );
    }
}
