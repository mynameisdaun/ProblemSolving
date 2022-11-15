package t.l;

import java.io.IOException;

public class n2_221113_kb {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        //int solution1 = solution.solution(12345678, 10, 20, 250000, 10000000, 4);
        long solution1 = solution.solution(1000000000L, 50, 99, 100000, 0, 6);
        System.out.println(solution1);
    }

    static class Solution {
        public long solution(long money, int minratio, int maxratio, int ranksize, int threshold, int months) {
            for (int i = 0; i < months; i++) {
                long predicted = money / 100 * 100;
//                System.out.println(i);
//                System.out.println("money: "+money);
//                System.out.println("predi: "+predicted);

                //threshold 미만은 세금 징수 안한다
                if (predicted < threshold) {
                    break;
                }
                int ratio = minratio;
                int right = threshold + ranksize - 1;
                while (ratio < maxratio) {
                    if (predicted > right) {
                        ratio++;
                        right += ranksize;
                    } else {
                        break;
                    }
                }
                ratio = Math.min(ratio, maxratio);
                //System.out.println("ratio: "+ratio);
                money -= predicted * ratio / 100;
            }
            return money;
        }
    }
}

