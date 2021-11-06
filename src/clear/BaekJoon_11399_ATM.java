package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaekJoon_11399_ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = 0 ;
        int answer=0;
        List<Integer> arr = Arrays
                              .stream(br.readLine().split(" "))
                              .map(Integer::parseInt)
                              .sorted()
                              .collect(Collectors.toList());
        for(Integer x : arr) {
//            System.out.println("지금 걸리는 분: "+x);
//            System.out.println("지금까지 누적된 분: "+sum);
//            System.out.println("이제 누적할 분: "+(x+sum));
              sum = (x+sum);
//            System.out.println("현재까지답: "+sum);
            answer+=sum;
        }
        System.out.println(answer);
    }

}



