package clear;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Map정렬연습 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = 3;
        int[] A = {1, 2, 5, 4, 3};
        int[] B = {5, 5, 6, 6, 5};
        int N = A.length;

        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j ++) {

            }
            if(K==0) break;
        }
        System.out.println(Arrays.stream(A).sum());
    }

}

