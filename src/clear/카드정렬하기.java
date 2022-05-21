package clear;

import java.io.*;
import java.util.PriorityQueue;

public class 카드정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0 ; i < N ; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        while(pq.size()>1) {
            int a = pq.poll();
            int b = pq.poll();
            int sum = a+b;
            answer+=sum;
            pq.offer(sum);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
        return;
    }
}
