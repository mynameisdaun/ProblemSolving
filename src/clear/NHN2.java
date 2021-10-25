package clear;


import java.util.*;

public class NHN2 {

    static int count = 0 ;
    static boolean[] visited = new boolean[9];
    static Map<Integer, Set<Integer>> map = new HashMap<Integer,Set<Integer>>();

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        List<Integer> branch= new LinkedList<Integer>();
        branch.add(2);
        branch.add(1);
        branch.add(3);
        branch.removeIf( a -> a==2);
        //branch.remove(2);
        Collections.sort(branch);

        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        List<Integer> keySetList = new ArrayList<>(map.keySet());

        // 오름차순
        System.out.println("------value 오름차순------");
        Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));

        for(Integer key : keySetList) {
            System.out.println("key : " + key + " / " + "value : " + map.get(key));
        }



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
