package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] memo = new long[31][31];
        for (int i = 0; i <= 30; i++) {
            for (int j = 0; j <= 30; j++) {
                memo[i][j] = -1L;
            }
        }
        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            System.out.println(count(memo, n, 0));
            n = Integer.parseInt(br.readLine());
        }
    }

    public static long count(long[][] memo, int w, int h) {
        if (memo[w][h] != -1) {
            return memo[w][h];
        }
        if (w == 1 && h == 0) return 1;
        if (w == 2 && h == 0) return 2;
        if (w == 3 && h == 0) return 5;
        if (w == 0) return memo[w][h] = 1;
        if (h > 0) {
            return memo[w][h] = count(memo, w, h - 1) + count(memo, w - 1, h + 1);
        }
        return memo[w][h] = count(memo, w - 1, h + 1);
    }
}
