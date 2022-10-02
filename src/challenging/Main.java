package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    static int T, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            dfs(1, "1");
            System.out.println();
        }
    }

    static void dfs(int L, String s) {
        if (s.length() == n * 2 - 1) {
            Queue<String> queue = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') continue;
                else if (!Character.isDigit(s.charAt(i))) {
                    queue.offer(sb.toString());
                    queue.offer(String.valueOf(s.charAt(i)));
                    sb = new StringBuilder();
                } else {
                    sb.append(s.charAt(i));
                }
            }
            queue.offer(sb.toString());
            int sum = Integer.parseInt(queue.poll());
            while (!queue.isEmpty()) {
                String op = queue.poll();
                int b = Integer.parseInt(queue.poll());
                if (op.equals("+")) {
                    sum += b;
                } else {
                    sum -=b ;
                }
            }
            if (sum == 0) {
                System.out.println(s);
            }
            return;
        }
        dfs(L + 1, s + " " + (L + 1));
        dfs(L + 1, s + "+" + (L + 1));
        dfs(L + 1, s + "-" + (L + 1));
    }

}
