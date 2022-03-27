package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int K = input[1];
        int answer = 0;

        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i < N ; i++) { list.add(Integer.parseInt(br.readLine()));}

        Collections.sort(list, Collections.reverseOrder());

        for(int i = 0 ; i < list.size() ; i ++) {
            if(K==0)
                break;
            int coin = list.get(i);
            int 몫 = K / coin;
            K -= (몫*coin);
            answer+=몫;
        }
        System.out.println(answer);
    }

}
