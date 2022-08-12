package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14501_퇴사 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            schedule[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int[] dp = new int[N + 1];
        int maxValue = 0;
        for (int i = N; i >= 1; i--) {
            int time = i + schedule[i][0] - 1;
            if(time > N) {
                dp[i] = maxValue;
            } else {
                dp[i] = Math.max(schedule[i][1] + (time==N ? 0 : dp[time+1]), maxValue);
                maxValue = dp[i];
            }
        }
        System.out.println(maxValue);
    }
}

