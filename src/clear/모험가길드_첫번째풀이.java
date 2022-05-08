package clear;

import java.io.IOException;
import java.util.Arrays;

public class 모험가길드_첫번째풀이 {
    private static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        int n  = 5;
        int answer = 0;
        int[] input = {2, 3, 1, 2, 2};
        Arrays.sort(input);

        for(int i=0;i<n;i++) {
            int count = input[i];
            for(int j=i;j<n;j++) {
                if(count==0) {
                    answer++;
                    break;
                };
                count--;
            }
            i+=input[i];
        }
        System.out.println(answer);
    }
}
