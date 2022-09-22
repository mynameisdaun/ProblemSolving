package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class BOJ_14891_톱니봐퀴 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Tooth> list = new ArrayList<>();
        list.add(null);
        for (int i = 0; i < 4; i++) {
            list.add(new Tooth(br.readLine()));
        }
        list.add(null);

        int N = parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            //번호, 방향
            int n = parseInt(input[0]);
            int rotate = parseInt(input[1]);
            List<int[]> memo = new ArrayList<>();
            Queue<int[]> queue = new LinkedList<>();
            boolean[] visited = new boolean[6];
            visited[n] = true;

            queue.offer(new int[]{n, rotate});
            memo.add(new int[]{n, rotate});

            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                int number = now[0];

                Tooth tooth = list.get(number);
                //오른쪽
                if (!visited[number + 1] && list.get(number + 1) != null) {
                    if (tooth.right() != list.get(number + 1).left()) {
                        memo.add(new int[]{number + 1, now[1] * -1});
                        visited[number + 1] = true;
                        queue.offer(new int[]{number + 1, now[1] * -1});
                    }
                }
                //왼쪽
                if (!visited[number - 1] && list.get(number - 1) != null) {
                    if (tooth.left() != list.get(number - 1).right()) {
                        memo.add(new int[]{number - 1, now[1] * -1});
                        visited[number - 1] = true;
                        queue.offer(new int[]{number - 1, now[1] * -1});
                    }
                }
            }
            for (int j = 0; j < memo.size(); j++) {
                list.get(memo.get(j)[0]).rotate(memo.get(j)[1]);
            }
        }
        int sum = 0;
        for (int i = 1; i <= 4; i++) {
            if (list.get(i).top() == 1) {
                sum += Math.pow(2, i - 1);
            }
        }
        System.out.println(sum);
    }

    static class Tooth {
        int[] seq;

        public Tooth(String input) {
            this.seq = Arrays.stream(input.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Integer top() {
            return this.seq[0];
        }

        Integer right() {
            return this.seq[2];
        }

        Integer left() {
            return this.seq[6];
        }

        void rotate(int d) {
            if (d == 1) {
                this.clock();
            } else {
                this.counterClock();
            }
        }

        void clock() {
            int top = seq[7];
            for (int i = 7; i >= 1; i--) {
                this.seq[i] = this.seq[i - 1];
            }
            this.seq[0] = top;
        }

        void counterClock() {
            int top = top();
            for (int i = 0; i < 7; i++) {
                this.seq[i] = this.seq[i + 1];
            }
            this.seq[7] = top;
        }
    }
}


