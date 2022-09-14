package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BOJ_1700_멀티탭스케쥴링 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays
                .stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = input[0];
        int k = input[1];

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Set<Integer> socket = new HashSet<>();

        int answer = 0;

        for (int i = 0; i < k ; i++) {
            int now = list.get(i);

            if (socket.contains(now)) continue;
            if (socket.size() < n && socket.add(now)) continue;

            int lastIndex = -100, value = -100;

            for (Integer s : socket) {

                List<Integer> sub = list.subList(i + 1, k);
                int idx = sub.indexOf(s);

                if (idx == -1) {
                    value = s;
                    break;
                }

                if(idx > lastIndex) {
                    lastIndex = idx;
                    value = s;
                }
            }

            socket.remove(value);
            socket.add(now);
            answer++;
        }
        System.out.println(answer);
    }
}

