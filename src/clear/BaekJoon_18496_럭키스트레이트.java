package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        int sum = 0;
        for(int i = 0 ; i < s.length ; i++) {
            if(i < s.length/2) {
                sum += Integer.parseInt(s[i]);
            } else {
                sum -= Integer.parseInt(s[i]);
            }
        }
        if(sum==0) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
