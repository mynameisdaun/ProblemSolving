package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BackJoon_9095_OnePlusTwoPlusThree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TEST_CASE = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < TEST_CASE ; i ++) {
            solution(Integer.parseInt(br.readLine()));
        }
    }

    static void solution(int number) {

        int[] dx = new int[12];
        dx[1] = 1;
        dx[2] = 2;
        dx[3] = 4;
        if(number<=3) {
            System.out.println(dx[number]);
        }else {
            for(int i=4; i<=number; i++) {
                dx[i] = dx[i-1]+dx[i-2]+dx[i-3];
            }
            System.out.println(dx[number]);
        }

    }


}
