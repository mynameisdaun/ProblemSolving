package challenging;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        String[] result = {"119", "97674223", "1195524421"};
        //solution.solution(result);

    }

    public int solution(String[][] clothes) {
        Map<String,Set<String>> map = new HashMap<String,Set<String>>();
        
        for(String[] cloth : clothes) {
            Set<String> set = map.getOrDefault(cloth[1], new HashSet<String>());
            set.add(cloth[0]);
            map.put(cloth[1],set);
        }
        return 1;
    }
}
