package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BOJ_1339_단어수학 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        String[] words = new String[n];

        for (int i = 1; i <= n; i++) {
            words[i-1] = br.readLine();
            String[] word = words[i-1].split("");
            for (int j = 0; j < word.length; j++) {
                int index = j + 1;
                String curr = word[word.length - 1 - j];
                int num = map.getOrDefault(curr, 0);
                map.put(curr, num + (int) (Math.pow(10, index)));
            }
        }
        int count = 9;
        List<String> list = map.entrySet()
                .stream()
                .sorted((a,b)->b.getValue()-a.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        for(int i = 0 ; i < list.size() ; i++) {
            String curr = list.get(i);
            map.put(curr, count-i);
        }
        int answer = 0;
        for(int i = 0 ; i < n ; i++) {
            String[] word = words[i].split("");
            for(int j = 0 ; j < word.length ; j++) {
                word[j] = String.valueOf(map.get(word[j]));
            }
            answer += Integer.parseInt(Arrays.stream(word).collect(Collectors.joining()));
        }
        System.out.println(answer);
    }
}
