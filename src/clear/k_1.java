package clear;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class k_1 {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
//        String today = "2020.01.01";
//        String[] terms = {"Z 3", "D 5"};
//        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        String today = "2022.01.01";
        String[] terms = {"A 1"};
        String[] privacies = {"2021.12.01 A"};

        int[] solution1 = solution.solution(today, terms, privacies);
        for (int i = 0; i < solution1.length; i++) {
            System.out.print(solution1[i] + " ");
        }
        System.out.println();
    }

    static class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            List<Integer> list = new ArrayList<>();
            Map<String, Long> map = new HashMap<>();
            for (int i = 0; i < terms.length; i++) {
                String[] term = terms[i].split(" ");
                map.put(term[0], Long.parseLong(term[1]));
            }

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy.MM.dd");
            LocalDate t = LocalDate.parse(today, fmt);
            for (int i = 0; i < privacies.length; i++) {
                String[] arr = privacies[i].split(" ");
                LocalDate n = LocalDate.parse(arr[0], fmt);

                LocalDate validate = n.plusMonths(map.get(arr[1])).minusDays(1);

                System.out.println(validate);
                System.out.println(validate.compareTo(t));

                if(validate.compareTo(t) < 0 ) {
                    list.add(i+1);
                }
            }
            int[] answer = new int[list.size()];
            for (int i = 0; i < list.size() ; i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}

