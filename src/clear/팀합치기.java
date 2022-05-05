package clear;

import java.io.IOException;

public class 팀합치기 {
    private static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        final int n = 7;
        final int m = 8;
        final int[][] input = {
                {0, 1, 3},
                {1, 1, 7},
                {0, 7, 6},
                {1, 7, 1},
                {0, 3, 7},
                {0, 4, 2},
                {0, 1, 1},
                {1, 1, 1},
        };

        int[] parents = new int[n+1];
        for(int i = 0 ; i <= n ; i++) {
            parents[i]=i;
        }

        for(int i = 0 ; i < m ; i++) {
            if(input[i][0]==0) {
                unionParent(parents, input[i][1], input[i][2]);
                continue;
            }
            if(findParent(parents, input[i][1])==findParent(parents, input[i][2])) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }

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
