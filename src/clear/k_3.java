package clear;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class k_3 {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
//        int[][] users = {{40, 10000}, {25, 10000}};
//        int[] emoticons = {7000, 9000};
        int[][] users = {{10, 10000}};
        int[] emoticons = {11000};
        int[] solution1 = solution.solution(users, emoticons);
        for (int i = 0; i < solution1.length; i++) {
            System.out.print(solution1[i]+" ");
        }
        System.out.println();
    }

    static class Solution {
        static int[] ratio = {10, 20, 30, 40};
        static int[] check;
        static List<int[]> list = new ArrayList<>();

        public static int[] solution(int[][] users, int[] emoticons) {
            check = new int[emoticons.length];
            dfs(0, users, emoticons);
            list.sort((a,b)-> {
                if(a[0]==b[0]) {
                    return b[1]-a[1];
                }
                return b[0]-a[0];
            });
            return list.size() == 0 ? new int[]{0,0} : list.get(0);
        }

        static void dfs(int L, int[][] users, int[] emoticons) {
            if (L == emoticons.length) {
//                for (int i = 0; i < check.length; i++) {
//                    System.out.print(check[i]+" ");
//                }
//                System.out.println();
                int plus = 0;
                int total = 0;
                for (int i = 0; i < users.length; i++) {
                    //System.out.println((i+1)+"번유저");
                    int[] user = users[i];
                    int cost = 0;
                    for (int j = 0; j < emoticons.length; j++) {
                        if (check[j] >= user[0]) {
                            //System.out.println((j+1)+" 번구매");
                            cost += (int) (((double)(100-check[j])/100) * emoticons[j]);
                        }
                    }
                    //System.out.println("cost: "+cost);
                    if (cost >= user[1]) {
                        plus++;
                    } else {
                        total += cost;
                    }
                }
                //System.out.println("plus: "+plus+" total: "+total);
                list.add(new int[]{plus, total});
            } else {
                for (int i = 0; i < 4; i++) {
                    check[L] = ratio[i];
                    dfs(L + 1, users, emoticons);
                }
            }
        }
    }


}

