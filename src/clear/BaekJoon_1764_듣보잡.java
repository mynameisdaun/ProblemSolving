package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int heard = Integer.parseInt(str[0]);
        int seen = Integer.parseInt(str[1]);

        PriorityQueue<String> pq = new PriorityQueue<String>();
        Set<String> heardSet = new HashSet<String>();
        Set<String> seenSet = new HashSet<String>();

        for(int i = 0 ; i < heard ; i++) {
            heardSet.add(br.readLine());
        }

        for(int i = 0 ; i < seen ; i ++) {
            String seenName = br.readLine();
            if(heardSet.contains(seenName)) {
                pq.offer(seenName);
            }
        }

        System.out.println(pq.size());
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }







    }

}



