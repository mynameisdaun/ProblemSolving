package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static boolean visited[], find = false;
    static List<ArrayList<Integer>> board = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            board.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            board.get(s).add(e);
            board.get(e).add(s);
        }

        for (int i = 0; i < n; i++) {
            dfs(1, i);
            if (find) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    static void dfs(int l, int s) {
        if (l == 5) {
            find = true;
            return;
        }
        visited[s] = true;
        for (Integer num : board.get(s)) {
            if (!visited[num]) {
                dfs(l + 1, num);
            }
        }
        visited[s] = false;
    }

}
