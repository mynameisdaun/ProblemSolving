package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer AbsO1 = Math.abs(o1);
                Integer AbsO2 = Math.abs(o2);
                if(AbsO1==AbsO2) {
                    return o1 - o2;
                } else {
                    return AbsO1 - AbsO2;
                }
            }
        });

        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i ++) {

            int input = Integer.parseInt(br.readLine());

            if(input==0) {
                if(pq.isEmpty()) System.out.println(0);
                else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.offer(input);
            }

        }

        br.close();



    }

}



