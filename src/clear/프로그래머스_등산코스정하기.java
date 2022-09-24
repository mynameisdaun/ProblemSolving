package clear;

import java.io.IOException;
import java.util.*;

public class 프로그래머스_등산코스정하기 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = 6;
//        int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
//        int[] gates = {1, 3};
//        int[] summits = {5};
//        int[] result = {5, 3};
        int n = 7;
        int[][] paths = {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}};
        int[] gates = {1};
        int[] summits = {2, 3, 4};
        int[] result = {5, 3};
        Solution solution = new Solution();
        int[] solution1 = solution.solution(n, paths, gates, summits);
        for (int i = 0; i < solution1.length; i++) {
            System.out.print(solution1[i] + " ");
        }
        System.out.println();
    }

    static class Solution {
        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            int[] answer = {-1, Integer.MAX_VALUE};
            List<ArrayList<int[]>> board = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                board.add(new ArrayList<>());
            }

            for (int i = 0; i < paths.length; i++) {
                int[] path = paths[i];
                int s = path[0];
                int e = path[1];
                int w = path[2];
                board.get(s).add(new int[]{e, w});
                board.get(e).add(new int[]{s, w});
            }
            Set<Integer> exit = new HashSet<>();
            for (int i = 0; i < summits.length; i++) {
                exit.add(summits[i]);
            }
            for (int i = 0; i < gates.length; i++) {
                int start = gates[i];
                int intensity = 0;
                boolean[] visited = new boolean[n + 1];

                for (int k = 0; k < gates.length; k++) {
                    if (i != k) visited[gates[k]] = true;
                }

                PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                    if(a[1]-b[1]==0) {
                        return a[0]-b[0];
                    }
                    return a[1] - b[1];
                });
                pq.add(new int[]{start, 0});

                while (!pq.isEmpty()) {
                    int[] node = pq.poll();
                    int index = node[0];
                    int weight = node[1];

                    if (!visited[index]) {
                        visited[index] = true;
                        intensity = Math.max(intensity, weight);
                        if (exit.contains(index)) {
                            if ((answer[1] > intensity) || (answer[1] == intensity && answer[0] > index)) {
                                answer[0] = index;
                                answer[1] = intensity;
                            }
                            break;
                        }
                        for (int[] edge : board.get(index)) {
                            if (!visited[edge[0]]) {
                                pq.add(edge);
                            }
                        }
                    }
                }
            }
            return answer;
        }
    }
}

