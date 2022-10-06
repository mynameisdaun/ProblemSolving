package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class BOJ_펠린드롬_question {
    static int seq[], dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        seq = new int[n + 1];
        StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            seq[i] = parseInt(tokens.nextToken());
        }
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (dp[i][j] == 0) {
                    dp[i][j] = check(i, j);
                }
            }
        }
        int m = parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            tokens = new StringTokenizer(br.readLine(), " ");
            if (dp[parseInt(tokens.nextToken())][parseInt(tokens.nextToken())] == 1) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    static int check(int start, int end) {
        if (dp[start][end] != 0) {
            return dp[start][end];
        } else if (start == end) {
            return dp[start][end] = 1;
        } else if (seq[start] != seq[end]) {
            return dp[start][end] = -1;
        } else if (start + 1 == end) {
            return dp[start][end] = 1;
        }
        return dp[start][end] = check(start + 1, end - 1);
    }
}
