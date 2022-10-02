package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2800_괄호제거 {

    static List<String> answer = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            Stack<Character> stack = new Stack<>();
            if (str.charAt(i) != '(') continue;

            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    stack.push('(');
                }
                if (str.charAt(j) == ')') {
                    if (stack.isEmpty()) {
                        list.add(new int[]{i, j});
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            combi(new int[i+1][2], 0, 0, i+1, list, str);
        }
        Collections.sort(answer);
        answer.stream().distinct().forEach(System.out::println);
    }

    public static void combi(int[][] cb, int L, int s, int m, List<int[]> list, String str) {
        if (L == m) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < m; i++) {
                set.add(cb[i][0]);
                set.add(cb[i][1]);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (!set.contains(i)) {
                    sb.append(str.charAt(i));
                }
            }
            answer.add(sb.toString());
        } else {
            for (int i = s; i < list.size(); i++) {
                cb[L] = list.get(i);
                combi(cb, L + 1, i + 1, m, list, str);
            }
        }
    }
}
