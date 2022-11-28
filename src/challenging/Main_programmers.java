package challenging;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main_programmers {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        String[] record = new String[]{"1 2 3 4 5 6 7 8", "2 11", "0 11 10", "3 17 19 12 13 9 14 15 10", "20 2 21"};
        int solution1 = solution.solution(record, 1, 9);
        System.out.println(solution1);
    }

    static class Solution {

        static boolean[] visited;
        static int answer = Integer.MAX_VALUE;

        static List<ArrayList<Integer>> board;

        static Map<Integer, Set<Integer>> map;

        public int solution(String[] subway, int start, int end) {
            board = new ArrayList<>();
            map = new HashMap<>();
            for (int i = 0; i < subway.length; i++) {
                int[] input = Arrays.stream(subway[i].split(" ")).mapToInt(Integer::parseInt).toArray();
                board.add(new ArrayList<>());
                for (int j = 0; j < input.length; j++) {
                    ArrayList<Integer> integers = board.get(i);
                    integers.add(input[j]);
                    Set set = map.getOrDefault(input[j], new HashSet());
                    set.add(i);
                    map.put(input[j], set);
                }
            }
            for (Integer line : map.get(start)) {
                visited = new boolean[1000000];
                dfs(0, line, start, end);
            }
            return answer;
        }

        static void dfs(int L, int line, int station, int end) {
            if (station == end) {
                answer = Math.min(answer, L);
                return;
            }
            for (int i = 0; i < board.get(line).size(); i++) {
                int next = board.get(line).get(i);
                if (!visited[next]) {
                    Set<Integer> set = map.get(next);
                    visited[next] = true;
                    for (Integer n : set) {
                        if (n == line) {
                            dfs(L, n, next, end);
                        } else {
                            dfs(L + 1, n, next, end);
                        }
                    }
                }
            }
        }
    }
}

