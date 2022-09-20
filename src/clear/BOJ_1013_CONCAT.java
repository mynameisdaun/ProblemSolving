package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BOJ_1013_CONCAT {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        String regex = "(100+1+|01)+";
        while (T-- > 0) {
            System.out.println(Pattern.matches(regex, br.readLine())
                    ? "YES"
                    : "NO");
        }
    }

}

