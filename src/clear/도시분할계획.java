package clear;

import java.io.IOException;
import java.util.Arrays;

public class 도시분할계획 {
    private static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        int answer = 0;
        int count = 0;
        final int n = 7;
        final int m = 12;
        final int[][] input = {
                {1, 2, 3},
                {1, 3, 2},
                {3, 2, 1},
                {2, 5, 2},
                {3, 4, 4},
                {7, 3, 6},
                {5, 1, 5},
                {1, 6, 2},
                {6, 4, 1},
                {6, 5, 3},
                {4, 5, 3},
                {6, 7, 4},
        };
        Arrays.sort(input, (a,b) -> a[2]-b[2]);

        int[] parents = new int[n+1];
        for(int i = 0 ; i <= n ; i++) {
            parents[i]=i;
        }
        
        for(int i = 0 ; i < m ; i++) {
            if(findParent(parents, input[i][0]) != findParent(parents, input[i][1])) {
                unionParent(parents, input[i][0], input[i][1]);
                if(++count < n-1) {
                    answer+=input[i][2];
                }
            }
        }
        System.out.println(answer);
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
