package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class BOJ_12738_가장_긴_증가하는_부분_수열_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = parseInt(br.readLine());
        int[] seq = new int[N];
        int[] dp = new int[N];

        StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            seq[i] = parseInt(tokens.nextToken());
        }

        dp[0] = seq[0];
        int index = 1;
        for (int i = 1; i < N; i++) {
            if (seq[i] > dp[index - 1]) {
                dp[index] = seq[i];
                index++;
            } else {
                int left = 0;
                int right = index;

                while(left < right) {
                    int mid = (left + right) / 2;
                    if(dp[mid] < seq[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                dp[left] = seq[i];
            }
        }
        System.out.println(index);
    }
}
