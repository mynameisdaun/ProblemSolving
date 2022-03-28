package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_2875_대회or인턴 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];int M = input[1];int K = input[2];
        int answer = 0;

        while(N>=2&&M>=1) { N-=2;M--;answer++;}
        //System.out.println("N: "+N+" M: "+M+" answer: "+answer);
        if(N+M < K) {
            //이 부분이 문제인 것 같당!
            int 빼야하는팀 = (int) Math.ceil((K-N-M) * 1.0 /3);
            System.out.println(Math.max(answer-빼야하는팀,0));
        } else {
            System.out.println(Math.max(answer,0));
        }
    }
}

