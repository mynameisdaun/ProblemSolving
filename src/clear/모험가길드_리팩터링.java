package clear;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class 모험가길드_리팩터링 {
    private static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        int n  = 5;
        int answer = 0;
        int[] input = {2, 3, 1, 2, 2};
        Arrays.stream(input).boxed().collect(Collectors.toList());

        Arrays.sort(input);

        int count = 0;
        for(int i=0; i<n; i++) {
            count++;
            if(count>=input[i]) {
                answer++;
                count=0;
            }
        }
        System.out.println(answer);
    }
}
