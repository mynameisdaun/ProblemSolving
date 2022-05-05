package clear;

import java.io.IOException;
import java.util.Arrays;

public class 위상정렬 {
    private static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        int answer = 0;
        final int n = 7;
        final int[][] input = {
                {1, 2, 29},
                {1, 5, 75},
                {2, 3, 35},
                {2, 6, 34},
                {3, 4, 7},
                {4, 6, 23},
                {4, 7, 13},
                {5, 6, 53},
                {6, 7, 25}
        };
        Arrays.sort(input, (a, b) -> a[2]-b[2]);
        final int[] parents = new int[n+1];
        for(int i = 1 ; i <= n ; i++) {
            parents[i]=i;
        }

        for(final int[] edge : input) {
            if(findParent(parents, edge[0]) != findParent(parents, edge[1])) {
                unionParent(parents, edge[0], edge[1]);
                answer+=edge[2];
            }
        }
        System.out.println(answer);
    }

    public static int findParent(final int[] arr,  final int a) {
        if(arr[a] != a) {
            return findParent(arr, arr[a]);
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
