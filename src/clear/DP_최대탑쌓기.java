package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DP_최대탑쌓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] bricks = new int[N][3];
        for (int i = 0; i < N; i++) {
            bricks[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        if (N == 1) {
            System.out.println(bricks[0][1]);
            return;
        }
        Arrays.sort(bricks, (a,b)->b[0]-a[0]);
        int[] dp = new int[N];
        dp[0] = bricks[0][1];
        for (int i = 1; i < bricks.length; i++) {
            dp[i] = bricks[i][1];
            for (int j = i - 1; j >= 0; j--) {
                if (bricks[i][2] < bricks[j][2]) {
                    dp[i] = Math.max(dp[i], bricks[i][1] + dp[j]);
                }
            }
//            for(int k = 0 ; k < dp.length; k++) {
//                System.out.print(dp[k]+" ");
//            }
//            System.out.println();
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
//5
//25 3 4
//4 4 6
//9 2 3
//16 2 5
//1 5 2
