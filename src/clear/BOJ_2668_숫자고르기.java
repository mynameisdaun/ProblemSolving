package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2668_숫자고르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        boolean memo[] = new boolean[n + 1];
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= n; i++) {
            if (memo[i]) continue;
            memo[i]=true;
            Set<Integer> set = new HashSet<>();
            int value = arr[i];
            while (true) {
                if (i == value) {
                    answer.add(i);
                    for (Integer num : set) {
                        answer.add(num);
                        memo[num]=true;
                    }
                    break;
                }
                if (set.contains(value)) {
                    break;
                }
                set.add(value);
                value = arr[value];
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        answer.forEach(System.out::println);
    }

}
