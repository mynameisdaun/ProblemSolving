package challenging;

import java.io.IOException;
import java.util.*;

public class Main_programmers {

    public static void main(String[] args) throws IOException {
        //Solution solution = new Solution();
        //Integer[] solution1 = solution.solution(new int[][]{{1, 5, 2, 3}, {2, 2, 3, 2}, {3, 1, 3, 3}, {5, 2, 1, 5}, {7, 1, 1, 1}, {9, 1, 1, 1}, {10, 2, 2, 9}});
        //Integer[] solution1 = solution.solution(new int[][]{{1,2,1,5}, {2,1,2,100},{3,2,1,5},{5,2,1,5}});
        //Integer[] solution1 = solution.solution(new int[][]{{0,2,3,1}, {5,3,3,1},{10,2,4,1}});
        //Integer[] solution1 = solution.solution(new int[][]{{0,5,1,1}, {2,4,3,3},{3,4,4,5},{5,2,3,2}});
        //같은 요청이 여러번 들어온 경우
        //우선순위의 합이 같다면 번호가 낮은게 먼저 출력된다.
        //Integer[] solution1 = solution.solution(new int[][]{{0,2,1,1}, {1,1,3,1},{2,1,4,1}});
        //우선순위의 합이 높은게 출력된다
        //Integer[] solution1 = solution.solution(new int[][]{{0,2,1,1}, {1,1,3,2}, {2,1,4,10},{3,1,4,1}}
        //Integer[] solution1 = solution.solution(new int[][]{{0, 100, 1, 1}, {101, 1, 2, 1});
/*        for (int i = 0; i < solution1.length; i++) {
            System.out.print(solution1[i] + " ");
        }*/
    }

        static class Solution {

            public Integer[] solution(int[][] jobs) {
                List<Integer> answer = new ArrayList<>();
                int index = 0;
                List<Task> list = new ArrayList<>();
                int time = jobs[0][0];

                while (!list.isEmpty() || index < jobs.length) {
                    //System.out.println("현재시간: "+ time + " 초 입니다 **********");
                    //System.out.println("새로운 태스크를 추가합니다");
                    while (index < jobs.length && jobs[index][0] <= time) {
                        Task t = new Task(index + 1, jobs[index]);
                        //System.out.println(t);
                        list.add(t);
                        index++;
                    }
                    if (list.isEmpty()) {
                        time++;
                        continue;
                    }
                    //System.out.println("===== 현재 우선순위를 보여드립니다. =====");
                    Collections.sort(list);
                    Task task = list.get(0);
                    //System.out.println("이번에 처리할 태스크 입니다.");
                    //System.out.println(task);
                    list.remove(0);

                    if (task.getType() != Task.currType) {
                        if (answer.isEmpty() || answer.get(answer.size() - 1) != task.getType()) {
                            answer.add(task.getType());
                        }
                        Task.currType = task.getType();
                    }
                    time += task.time;
                    Task.sum.put(task.getType(), Task.sum.get(task.getType()) - task.getPriority());
                }
                return answer.stream().toArray(Integer[]::new);
            }


            static class Task implements Comparable<Task> {

                static Map<Integer, Integer> sum = new HashMap<>();
                static int currType = 0;

                static {
                    for (int i = 1; i <= 100; i++) {
                        sum.put(i, 0);
                    }
                }

                private int idx;
                private int req;
                private int time;
                private int type;
                private int priority;

                public Task(int idx, int req, int time, int type, int priority) {
                    this.idx = idx;
                    this.req = req;
                    this.time = time;
                    this.type = type;
                    this.priority = priority;
                    sum.put(type, sum.get(type) + priority);
                }

                public Task(int idx, int[] job) {
                    this(idx, job[0], job[1], job[2], job[3]);
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

                @Override
                public String toString() {
                    return "Task{" +
                            "idx=" + idx +
                            ", req=" + req +
                            ", time=" + time +
                            ", type=" + type +
                            ", priority=" + priority +
                            '}';
                }
            }
        }
    }

