package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1764_듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int heard = Integer.parseInt(str[0]);
        int seen = Integer.parseInt(str[1]);

        List<String> pq = new ArrayList<String>();
        Set<String> heardSet = new HashSet<String>();
        Set<String> seenSet = new HashSet<String>();

        for(int i = 0 ; i < heard ; i++) {
            heardSet.add(br.readLine());
        }

        for(int i = 0 ; i < seen ; i ++) {
            String seenName = br.readLine();
            if(heardSet.contains(seenName)) {
                pq.add(seenName);
            }
        }
        Collections.sort(pq);
        System.out.println(pq.size());
        for(String x: pq) {
            System.out.println(x);
        }







    }

}



