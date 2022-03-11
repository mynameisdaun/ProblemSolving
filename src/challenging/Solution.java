package challenging;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        solution.solution(progresses, speeds);

    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> tmp = new LinkedList<Integer>();

        Queue<Progress> queue = new LinkedList<Progress>();
        for(int i = 0 ; i < progresses.length ; i ++) {
            queue.offer(new Progress(progresses[i], speeds[i]));
        }
        while( !queue.isEmpty() && queue.peek().getProgress() < 100) {
            //일한다
            int size = 0 ;
            queue.forEach( a -> a.work());
            while(!queue.isEmpty() && queue.peek().getProgress() >= 100) {
                queue.poll();
                size++;
            }
            tmp.add(size);
        }
        Integer a = 1;;;
        tmp.stream().map(Integer::intValue).collect(Collectors.toList()).toArray();
        return answer;
    }

    static class Progress {
        private int progress;
        private int speed;

        public Progress(int p, int s) {
            this.progress =p;
            this.speed =s;
        }

        public boolean isCompleted() {
            return progress >= 100 ? true : false;
        }

        public void work() {
            this.progress += this.speed;
        }

        public int getProgress() {
            return progress;
        }

        public int getSpeed() {
            return speed;
        }
    }
}
