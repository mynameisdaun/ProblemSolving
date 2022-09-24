package challenging;

import java.io.IOException;
import java.util.Arrays;

public class Main_programmers {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        int[][] fees = {{4, 1000}, {6, 1000}, {21, 3000}, {16, 2000}, {26, 3000}};
        int t = 27;
        long[] solution1 = solution.solution(fees, t);
    }

    static class Solution {
        public long[] solution(int[][] fees, int t) {
            //b -> 기본요금, 주차시간 -> a
            long[] answer = {};
            Arrays.sort(fees, (a, b) -> {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });


            int start = 1;
            int end = 1000000;

            while(start < end) {
                int mid = end;

            }


            for (int i = 0; i < fees.length; i++) {
                System.out.println(fees[i][0] + " " + fees[i][1]);
            }
            System.out.println();
            //없을때는 -1 return
            /*
            4 1000
            6 1000
            16 2000
            21 3000
            26 3000
             */
            return answer;
        }
    }
}

