package t.l;

import java.io.IOException;

public class n3_221113_s {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        //long solution1 = solution.solution(new int[]{2,3,4,5,1});
        long solution1 = solution.solution(new int[]{3, 1, 2, 4});
        System.out.println(solution1);
    }

    static class Solution {
        static boolean[] opened;
        static boolean cycled = false;

        public int solution(int[] rooms) {
            int n = rooms.length;
            opened = new boolean[n + 1];
            int masterKey = 0;

            for (int i = 1; i <= n; i++) {
                if (!opened[i]) {
                    masterKey++;
                    opened[i] = true;
                    dfs(rooms, rooms[i-1]);
                }
            }
            if(cycled) {
                masterKey--;
            }
            return Math.max(1,masterKey);
        }

        static void dfs(int[] rooms, int s) {
            if (opened[s]) {
                cycled = true;
                return;
            }
            opened[s] = true;
            dfs(rooms, rooms[s-1]);
        }
    }
}

