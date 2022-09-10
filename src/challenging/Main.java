package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        String[] words = new String[n];
        for (int i = 1; i <= n; i++) {
            words[i - 1] = br.readLine();
            String[] word = words[i - 1].split("");
            for (int j = 0; j < word.length; j++) {
                int index = j + 1;
                String curr = word[word.length - 1 - j];
                int num = map.getOrDefault(curr, 0);
                map.put(curr, num + (int) (Math.pow(10, index - 1)));
            }
        }
        int count = 9;
        int answer = 0;
        List<Integer> list = map.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .map(a -> a.getValue())
                .collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            answer += (list.get(i) * count--);
        }
        System.out.println(answer);;
    }
}
