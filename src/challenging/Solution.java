package challenging;

import java.util.*;

import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        int answer = 0;
        List<Node> list = new ArrayList<Node>();
        for(int[] arr : dungeons) {
            list.add(new Node(arr[0], arr[1]));
        }
        Collections.sort(list);
        PriorityQueue<Integer> pQ = new PriorityQueue<Integer>();


        int j = 0;
        for(int i = k ; i >= 0 ; i--) {
            System.out.println("i: "+i+" j: "+j);
            for( ; j < n ; j++) {
                if(list.get(j).getM() < i) break;
                pQ.offer(list.get(j).getE());
            }
            if(!pQ.isEmpty()) {
                int e = pQ.poll();
                System.out.println("i: "+i+" j: "+j+" e: "+e);
                i-=e;
                answer++;
            }
        }
        return answer;
    }

    class Node implements Comparable<Node> {
        private int m;
        private int e;

        public Node (int m, int e) {
            this.m=m;
            this.e=e;
        }

        public int getM() {
            return this.m;
        }
        public int getE() {
            return this.e;
        }
        @Override
        public int compareTo(Node o) {
            return o.m-this.m;
        }
    }
}
