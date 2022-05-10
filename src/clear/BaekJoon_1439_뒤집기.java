package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_1439_뒤집기 {

    public static void main(String[] args) throws IOException {
         //String s = "0001100";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if(s.length()==1) {
            System.out.println(0);
            return;
        }
        int zeroGroup = 0;
        int oneGroup = 0;

        char curr = s.charAt(0);

        if(curr=='0') {
            zeroGroup++;
        } else {
            oneGroup++;
        }

        for(int i = 1 ; i < s.length() ; i++) {
            if (s.charAt(i) != curr) {
                if(s.charAt(i)=='0') {
                    zeroGroup++;
                }else {
                    oneGroup++;
                }
                curr=s.charAt(i);
            }
        }
        System.out.println(Math.min(zeroGroup, oneGroup));
    }
}
