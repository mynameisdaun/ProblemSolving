package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, l, r, x, target, cb[], arr[], answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        l = input[1];
        r = input[2];
        x = input[3];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if(n==1) {
            System.out.println(0);
            return;
        }
        Arrays.sort(arr);

        for (int i = 2; i <= n ; i++) {
            cb = new int[i];
            target = i;
            dfs(0,0);
        }
        System.out.println(answer);
    }

    public static void dfs(int d, int s) {
        if (d == target) {
            int sum = Arrays.stream(cb).sum();
            if (sum >= l && sum <= r && cb[d - 1] - cb[0] >= x) answer++;
        } else {
            for (int i = s; i < n; i++) {
                cb[d] = arr[i];
                dfs(d + 1, i + 1);
            }
        }
    }
}
