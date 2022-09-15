package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_2437_저울 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 1;

        List<Integer> list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        if (list.indexOf(1) < 0) {
            System.out.println(answer);
            return;
        }
        if (list.indexOf(1) == list.lastIndexOf(1)) {
            System.out.println(2);
            return;
        }

        Collections.sort(list);

        int idx = 1;
        Map<Integer, boolean[]> memo = new HashMap<>();

        while (true) {
            if (list.contains(idx)) {
                idx++;
                continue;
            }
            int a = idx - 1;
            while (true) {
                boolean[] visited = new boolean[n];
                int b = idx - a;
                if (a < b) {
                    System.out.println(idx);
                    return;
                }
                if (find(a, list, memo, visited) && find(b, list, memo, visited)) {
                    memo.put(idx, visited);
                    break;
                }
                a--;
            }
            idx++;
        }
    }

    public static boolean find(int num, List<Integer> list, Map<Integer, boolean[]> memo, boolean[] visited) {
        int index = list.indexOf(num);
        while (index >= 0 && index < list.size() && list.get(index) == num) {
            if (!visited[index]) {
                visited[index] = true;
                return true;
            }
            index++;
        }

        boolean[] info = memo.get(num);
        if (info != null) {
            for (int i = 0; i < info.length; i++) {
                if (info[i] && visited[i]) return false;
            }
            for (int i = 0; i < info.length; i++) {
                if (info[i]) {
                    visited[i] = true;
                }
            }
            return true;
        }
        return false;
    }
}
