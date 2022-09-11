package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1107_리모컨 {
    static int INF = 1000000;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        if(n>0) {
            input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        boolean[] broken = new boolean[10];

        for(int i = 0 ; i < input.length ; i++) {
            broken[input[i]] = true;
        }
        int answer = Math.abs(Integer.parseInt(str)-100);

        for(int i = 0 ; i < INF ; i++) {
            String now = String.valueOf(i);

            boolean find = false;
            for(int j = 0 ; j < input.length ; j++) {
                String s = String.valueOf(input[j]);
                if(now.contains(s)) {
                    find=true;
                    break;
                }
            }
            if(!find) {
                int min = Math.abs(Integer.parseInt(str)-i) + now.length();
                answer = Math.min(min,answer);
            }
        }
        System.out.println(answer);
    }
}
