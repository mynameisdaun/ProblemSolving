package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class BOJ_회문_17609 {

    static int left, right, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int T = parseInt(br.readLine()); T-- > 0; ) {
            String str = br.readLine();
            left = 0;
            right = str.length() - 1;
            count = 0;
            while (left < right) {
                if (str.charAt(left) == str.charAt(right)) {
                    left++;
                    right--;
                } else {
                    count++;
                    left++;
                }
            }
            if (count <= 1) {
                System.out.println(count);
                continue;
            }
            left = 0;
            right = str.length() - 1;
            count = 0;
            while (left < right) {
                if (str.charAt(left) == str.charAt(right)) {
                    left++;
                    right--;
                } else {
                    count++;
                    right--;
                }
            }
            if (count <= 1) {
                System.out.println(count);
            } else {
                System.out.println(2);
            }
        }
    }
}

