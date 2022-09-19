package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class BOJ_FLY_ME_어쩌구 {

    static int T, dp[], INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int x = parseInt(input[0]);
            int y = parseInt(input[1]);
            dp = new int[y + 1];
            INF = y-x;
            Arrays.fill(dp, INF);
            dp[x] = 0;
            int cnt = 1;

            while (true) {
                int pos = x + cnt;
                if (pos > y) break;
                for (int i = 0; i < cnt; i++) {
                    if (pos + i <= y) {
                        dp[pos + i] = Math.min(cnt, dp[pos + i]);
                    }
                }
                cnt++;
            }

            int answer = INF;
//            for (int i = x; i <= y ; i++) {
//                System.out.print(dp[i]+" ");
//            }
//            System.out.println();

            for (int i = 0; i <= y - x; i++) {
                if (Math.abs(dp[x + i] - dp[y - i]) <= 1) {
                    answer = Math.min(answer, dp[x + i] + dp[y - i]);
                }
            }
            System.out.println(answer);
        }
    }
}

