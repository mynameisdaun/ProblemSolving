package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904_A와B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        while (s.length() != t.length()) {
            StringBuilder sb = new StringBuilder();
            if (t.charAt(t.length() - 1) == 'A') {
                sb.append(t.substring(0, t.length() - 1));
            } else {
                for (int i = t.length()-2; i >=0; i--) {
                    sb.append(t.charAt(i));
                }
            }
            t = sb.toString();
            //System.out.println(t);
        }
        System.out.println(s.equals(t) ? 1 : 0);
    }

}

