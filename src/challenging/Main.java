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
        Arrays.stream(input).forEach(a->{
            graph[a[0]][a[1]]=1;
            inDegree[a[1]]++;
        });

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 1 ; i <= n ; i++) {
            if(inDegree[i]==0)
                queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int cur;
        }




        final boolean[] visited = new boolean[n];

    }

    public static int findParent(final int[] parents,  final int a) {
        if(parents[a] != a) {
            return findParent(parents, parents[a]);
        }
        return a;
    }

    public static void unionParent(final int[] arr, final  int a, final int b) {
        int pa = findParent(arr, a);
        int pb = findParent(arr, b);
        if(pa<pb) {
            arr[pb] = pa;
        } else {
            arr[pa] = pb;
        }
    }
}
