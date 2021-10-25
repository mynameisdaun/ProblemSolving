package clear;

import java.util.*;

class MenuRenewal {

    public static void main(String[] args) {
        MenuRenewal MR = new MenuRenewal();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        for(String x: MR.solution(orders, course)) {
            System.out.println(x);
        }
    }


    static Map<String, Integer> combiMap = new HashMap<String, Integer>();
    static Map<String, Integer> filteredCombiMap = new HashMap<String, Integer>();
    public String[] solution(String[] orders, int[] course) {

        List<String> answer = new LinkedList<String>();

        for(int NumberOfMenu : course) {
            combiMap.clear();
            filteredCombiMap.clear();
            getCombiFromOrders(orders, NumberOfMenu);
            int max = Integer.MIN_VALUE;

            for(Map.Entry<String, Integer> entry: combiMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();

                    if(value >= max && value > 1) {
                        if(value > max) {
                            max = value;
                            filteredCombiMap.clear();
                        }
                        filteredCombiMap.put(key,value);
                    }
            }

            filteredCombiMap.forEach((key, value) -> answer.add(key));
        }
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }

    private void getCombiFromOrders(String[] orders, int NumberOfMenu) {

        for(String order : orders) {
            boolean[] check = new boolean[order.length()];
            DFS(0, toSortedstr(order), NumberOfMenu, "", check);
        }
    }

    private void DFS(int L, String order, int NumberOfMenu, String combi, boolean[] check) {

        if(combi.length() == NumberOfMenu) {
            combiMap.put(combi, combiMap.getOrDefault(combi,0)+1);
        }
        else {
            for(int i = L ; i < order.length(); i ++) {
                if(!check[i]){
                    check[i] = true;
                    String newCombi = combi + order.charAt(i);
                    DFS(i+1, order, NumberOfMenu, newCombi, check);
                    check[i] = false;
                }
            }
        }

    }

    private String toSortedstr(String order) {
        char[] arr = order.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }








}