package t.l;

import java.io.IOException;

public class n1_221113_kb {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int[] solution1 = solution.solution("2019/05/01 00:59:19\n2019/06/01 01:35:20\n2019/08/01 02:01:22\n2019/08/01 02:01:23\n2019/08/02 03:02:35\n2019/10/03 04:05:40\n2019/10/04 06:23:10\n2019/10/01 08:23:20\n2019/10/01 08:42:24\n2019/10/01 08:43:26\n2019/11/01 08:43:29\n2019/11/01 10:19:02\n2019/12/01 11:23:10");
        for (int i = 0; i < solution1.length; i++) {
            System.out.println(solution1[i]+" ");
        }
    }

    static class Solution {
        public int[] solution(String logs) {
            int[] answer = new int[24];
            String[] inputs = logs.split("\n");

            for(String input: inputs) {
                String tms = input.split(" ")[1];
                int t = Integer.parseInt(tms.split(":")[0]);
                int koreaTime = (t+9) % 24;
                answer[koreaTime]++;
            }
            return answer;
        }

    }
}

