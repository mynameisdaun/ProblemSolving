package clear;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class 커리큘럼 {
    private static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        final int n = 5;
        final int input[][] = {
                {10, -1},
                {10, 1, -1},
                {4, 1, -1},
                {4, 3, 1, -1},
                {3, 3, -1}
        };

        final int[][] graph = new int[n+1][n+1];
        final int[] time = new int[n+1];
        final int[] inDegree = new int[n+1];
        final int[] answer = new int[n+1];

        for(int i = 0 ; i < input.length ; i++) {
            int end = i+1;
            time[end] = input[i][0];
            for(int j = 1 ; j < input[i].length ; j++) {
                if(input[i][j]==-1) break;
                int start = input[i][j];
                graph[start][end]=1;
                inDegree[end]++;
            }
        }

        Queue<Lecture> queue = new LinkedList<Lecture>();
        IntStream.range(1, n)
                .filter(i->inDegree[i]==0)
                .forEach(i->queue.offer(new Lecture(i, time[i])));

        while(!queue.isEmpty()) {
            Lecture now = queue.poll();
            answer[now.number] = Math.max(answer[now.number], now.time);

            for(int i = 1; i <=n ; i++) {
                if(i == now.number || graph[now.number][i]!=1) continue;
                inDegree[i]--;
                if(inDegree[i]==0) {
                    queue.offer(new Lecture(i, now.time+time[i]));
                }
            }
        }
        IntStream.range(1,n+1)
                .forEach(i->System.out.println(answer[i]));
    }
    static class Lecture {
        private int number;
        private int time;

        public Lecture(int number, int time) {
            this.number = number;
            this.time = time;
        }
    }
}
