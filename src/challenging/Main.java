package challenging;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        int answer = 0;
        int count = 0;
        final int n = 7;
        final int m = 8;
        final int[][] input = {
                {1, 2},
                {1, 5},
                {2, 3},
                {2, 6},
                {3, 4},
                {4, 7},
                {5, 6},
                {6, 4},
        };
        final int[][] graph = new int[n+1][n+1];
        final int[] inDegree = new int[n+1];
        inDegree[0]=INF;

        for(int i=0 ; i<m ; i++) {
            int x = input[i][0];
            int y = input[i][1];
            graph[x][y] = 1;
            inDegree[y]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n ;i++) {
            if(inDegree[i]==0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            //answer
            System.out.print(curr+" ");
            for(int i=1 ; i<=n ; i++) {
                if(i==curr||graph[curr][i]!=1) continue;
                inDegree[i]--;
                if(inDegree[i]==0) {
                    queue.offer(i);
                }
            }
        }
    }
}
