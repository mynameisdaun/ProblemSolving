package clear;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 볼링공고르기 {

    public static void main(String[] args) throws IOException {
        int N = 8;
        int M = 5;
        int[] input = {1, 3, 2, 3, 2};
        Map<Integer, Long> map = Arrays.stream(input)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        Long sum = 0L;
        for(int i = 1 ; i <= M ; i++) {
            Long currValue = map.getOrDefault(i, Long.valueOf(0));
            Long currSum = 0L;
            for(int j=i+1;j<=M;j++) {
                currSum += map.getOrDefault(j,Long.valueOf(0));
            }
            sum += (currValue*currSum);
        }
        System.out.println(sum);

    }
}
