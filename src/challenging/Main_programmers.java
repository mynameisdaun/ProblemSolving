package challenging;

import java.io.IOException;
import java.util.PriorityQueue;

public class Main_programmers {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int n = 3;
        int m = 4;
        int x = 2;
        int y = 3;
        int r = 3;
        int c = 1;
        int k =  5;


    }

    static class Solution {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;
            //dp냐 그리디냐
            PriorityQueue<int[]> deliveryQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            PriorityQueue<int[]> pickupQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);

            for (int i = 0; i < n; i++) {
                if (deliveries[i] > 0) {
                    deliveryQueue.add(new int[]{i+1, deliveries[i]});
                }
                if (pickups[i] > 0) {
                    pickupQueue.add(new int[]{i+1, pickups[i]});
                }
            }

            while(true) {

                int truck = cap;
                int distance = -1;
                System.out.println("딜리버리");
                while (!deliveryQueue.isEmpty()) {
                    int[] node = deliveryQueue.poll();
                    System.out.println("index: "+node[0]+" stuffs: "+node[1]);
                    if (truck >= node[1]) {
                        truck -= node[1];
                        distance = Math.max(distance, node[0]);
                    } else if (truck < node[1]) {
                        deliveryQueue.offer(new int[]{node[0], node[1] - truck});
                        distance = Math.max(distance, node[0]);
                        truck = 0;
                    }
                    if(truck==0) break;
                }

                truck = cap;
                System.out.println("픽업");

                if(distance > 0) {
                    answer += (distance * 2);
                }
                if(deliveryQueue.isEmpty()&&pickupQueue.isEmpty()) break;
            }
            return answer;
        }
    }
}

