package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1717_집합의표현 {

    public static void union(int[] parent, int a, int b) {
        int a_parent = find(parent, a);
        int b_parent = find(parent, b);

        if (a_parent < b_parent)
            parent[b_parent] = a_parent;
        else
            parent[a_parent] = b_parent;
    }

    public static int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent, parent[i]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] memo = new int[input[0] + 1];
        for (int i = 0; i <= input[0]; i++) {
            memo[i] = i;
        }

        for (int i = 0; i < input[1]; i++) {
            int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int op = in[0];
            int a = in[1];
            int b = in[2];
            boolean sameParent = find(memo, a) == find(memo, b);
            if (op == 0) {
                if (!sameParent) {
                    union(memo, a, b);
                }
                continue;
            }
            System.out.println(sameParent ? "YES" : "NO");
        }
    }
}
