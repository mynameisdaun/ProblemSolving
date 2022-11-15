package t.l;

import java.io.IOException;
import java.util.*;

public class n4_221113_kb {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();

        //Integer[] solution1 = solution.solution(new int[][]{{1,2,1,5}, {2,1,2,100},{3,2,1,5},{5,2,1,5}});
        //Integer[] solution1 = solution.solution(new int[][]{{1,5,2,3}, {2,2,3,2},{3,1,3,3},{5,2,1,5},{7,1,1,1},{9,1,1,1},{10,2,2,9}});
        //Integer[] solution1 = solution.solution(new int[][]{{0, 10, 1, 2}, {21,1,30,100}});
        //Integer[] solution1 = solution.solution(new int[][]{{0,2,3,1}, {5,3,3,1},{10,2,4,1}});
        //같은 요청이 여러번 들어온 경우
        //우선순위의 합이 같다면 번호가 낮은게 먼저 출력된다.
        //Integer[] solution1 = solution.solution(new int[][]{{0,2,1,1}, {1,1,3,1},{2,1,4,1}});
        //우선순위의 합이 높은게 출력된다
        //Integer[] solution1 = solution.solution(new int[][]{{0,2,1,1}, {1,1,3,2}, {2,1,4,10},{3,1,4,1}});
        //Integer[] solution1 = solution.solution(new int[][]{{0, 100, 1, 1}, {100, 1, 2, 1}});
        Integer[] solution1 = solution.solution(new int[][]{{0, 10000, 1, 1}, {1000000, 1, 2, 1}});
        //Integer[] solution1 = solution.solution(new int[][]{{1, 100, 1, 3}, {2, 100, 2, 50},{3, 100, 2, 50},{4, 100, 2, 5},{5, 100, 4, 110}});
        for (int i = 0; i < solution1.length; i++) {
            System.out.print(solution1[i] + " ");
        }
    }


    static class Solution {

        public Integer[] solution(int[][] jobs) {
            List<Integer> tmp = new ArrayList<>();
            int index = 0;
            int time = 0;
            List<Task> list = new ArrayList<>();
            while (!list.isEmpty() || index < jobs.length) {
                while (index < jobs.length && jobs[index][0] <= time) {
                    Task t = new Task(jobs[index]);
                    list.add(t);
                    Task.sum.put(t.type, Task.sum.get(t.type) + t.priority);
                    index++;
                }
                if (list.isEmpty()) {
                    time++;
                    continue;
                }
                Collections.sort(list);
                Task task = list.get(0);
                Task.sum.put(task.getType(), Task.sum.get(task.getType()) - task.getPriority());
                list.remove(0);

                tmp.add(task.getType());
                Task.currType = task.getType();
                time += task.time-1;
            }

            List<Integer> answer = new ArrayList<>();
            int curr = tmp.get(0);
            answer.add(curr);
            for (int i = 1; i < tmp.size(); i++) {
                if (curr != tmp.get(i)) {
                    answer.add(tmp.get(i));
                    curr = tmp.get(i);
                }
            }
            return answer.stream().toArray(Integer[]::new);
        }


        static class Task implements Comparable<Task> {

            static Map<Integer, Integer> sum = new HashMap<>();
            static int currType = 0;

            static {
                for (int i = 0; i <= 101; i++) {
                    sum.put(i, 0);
                }
            }

            private int req;
            private int time;
            private int type;
            private int priority;

            public Task(int req, int time, int type, int priority) {
                this.req = req;
                this.time = time;
                this.type = type;
                this.priority = priority;
            }

            public Task(int[] job) {
                this(job[0], job[1], job[2], job[3]);
            }

            public int getReq() {
                return req;
            }

            public int getTime() {
                return time;
            }

            public int getType() {
                return type;
            }

            public int getPriority() {
                return priority;
            }

            @Override
            public int compareTo(Task o) {
                if (this.type != o.type) {
                    if (this.type == currType) {
                        return -1;
                    }
                    if (o.type == currType) {
                        return 1;
                    }
                }
                if (sum.get(this.type) != sum.get(o.type)) {
                    return sum.get(o.type) - sum.get(this.type);
                }
                return this.type - o.type;
            }
        }
    }
}

