package ps;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NHN {

    static int count = 0 ;
    static boolean[] visited = new boolean[9];
    static Map<Integer, Set<Integer>> map = new HashMap<Integer,Set<Integer>>();

    public static void main(String[] args) {
        NHN nhn = new NHN();
        nhn.solution(4, new int[][] {{3,6},{5,7},{4,1},{8,7}});
    }

    public void solution(int numOfConflict, int[][] conflicts) {

        for(int[] conflict : conflicts) {
            Set<Integer> setForZero = map.getOrDefault(conflict[0], new HashSet<Integer>());
            Set<Integer> setForOne = map.getOrDefault(conflict[1], new HashSet<Integer>());
            setForZero.add(conflict[1]);
            setForOne.add(conflict[0]);
            map.put(conflict[0],setForZero);
            map.put(conflict[1],setForOne);
        }
        permutation("");

        System.out.println(count);
    }

    static void permutation(String seatOrder) {

        if(seatOrder.length()==8) {
            count++;
            System.out.println(seatOrder);

        } else {
            for(int i = 1 ; i <= 8 ; i ++) {

                if(!visited[i]) {
                    Set<Integer> conflictStudentSet = map.getOrDefault(i,new HashSet<Integer>());
                    if(seatOrder.length()>=1&&conflictStudentSet.contains(Character.getNumericValue(seatOrder.charAt(seatOrder.length()-1)))) {
                        continue;
                    }
                    visited[i] = true;
                    permutation(seatOrder+i);
                    visited[i]=false;
                }
            }

        }
    }



}
