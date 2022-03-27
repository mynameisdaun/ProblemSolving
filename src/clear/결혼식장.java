package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Room> list = new ArrayList<>();
        Stack<Room> stack = new Stack<>();
        int time = Integer.MIN_VALUE;
        int answer =0;
        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(new Room(1, input[0]));
            list.add(new Room(0, input[1]));
        }
        Collections.sort(list);

        for(Room r : list) {
            if(r.isArrive==1)
                stack.push(r);
            else {
                answer = Math.max(answer, stack.size());
                stack.pop();
            }
        }
        System.out.println(answer);
    }

    static class Room implements Comparable<Room>{
        // 1 -> Arrive, 0 -> leave
        private int isArrive;
        private int time;

        public Room(int isArrive, int time) {
            this.isArrive = isArrive;
            this.time = time;
        }

        @Override
        public int compareTo(Room o) {
            if(this.time == o.time)
                return this.isArrive - o.isArrive;
            return this.time - o.time;
        }
    }
}
