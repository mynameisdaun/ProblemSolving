package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9935_문자열폭발 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        while (str.indexOf(bomb) > -1) {
            str = str.replace(bomb, "");
        }
        if (str.equals("")) {
            System.out.println("FRULA");
            return;
        }
        System.out.println(str);
    }
}
