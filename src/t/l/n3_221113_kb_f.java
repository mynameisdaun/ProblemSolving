package t.l;

import java.io.IOException;

public class n3_221113_kb_f {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        //long solution1 = solution.solution(new int[]{2,3,4,5,1});
        long solution1 = solution.solution(new int[]{1,3,2,4,6,5,7,8});
        System.out.println(solution1);
    }

    static class Solution {

        static int[] parent;

        static void union(int a, int b) {
            if (a < b)
                parent[b] = a;
            else
                parent[a] = b;
        }

        static int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }

        //111 4
        public int solution(int[] rooms) {
            int n = rooms.length;
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
            int masterKey = 0;
            for (int i = 0; i < rooms.length; i++) {
                int pA = find(i + 1);
                int pB = find(rooms[i]);
                if (pA != pB) {
                    union(pA, pB);
                }
            }
            int count = 0;
            boolean[] checked = new boolean[n + 1];
            for (int i = 1; i <= n ; i++) {
                if(!checked[parent[i]]) {
                    count++;
                    checked[parent[i]]=true;
                }
            }
            return Math.max(1 , count-1);
        }
    }
}

