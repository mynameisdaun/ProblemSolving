package again;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BaekJoon_AC_5403 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("");
tc:		for (int i = 0; i < TC; i++) {

            String func = br.readLine(); // RDD
            boolean isReverse = false;
            int size = Integer.parseInt(br.readLine()); // 4
            Deque<Integer> deque = new LinkedList<>();
            String temp = br.readLine().replace("[", "").replace("]", "").replace(",", " ");
            StringTokenizer st = new StringTokenizer(temp);
            for (int j = 0; j < size; j++) { // [1,2,3,4]
                deque.add(Integer.parseInt(st.nextToken()));
            }

            for (char c : func.toCharArray()) {
                if (c == 'R') {
                    isReverse = !isReverse;
                } else { // D 일때
                    if (deque.isEmpty()) {
                        sb.append("error").append("\n");
                        continue tc;
                    }
                    if (isReverse) {// 역순이면
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }

            }
            sb.append("[");
            while (!deque.isEmpty()) {
                if (isReverse) {
                    if(size==1) {
                        sb.append(deque.removeLast());
                        continue;
                    }
                    sb.append(deque.removeLast()).append(",");
                } else {
                    sb.append(deque.removeFirst()).append(",");
                }
            }
            if(size > 1 ) {
                sb.deleteCharAt(sb.lastIndexOf(","));
            }
            sb.append("]").append("\n");


        }
        System.out.print(sb);
    }

}