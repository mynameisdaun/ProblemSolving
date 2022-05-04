package clear;

import java.io.IOException;
import java.util.Arrays;

public class UnionAndFind {
    private static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        int n = 6;
        int[][] input = {
                {1, 4},
                {2, 3},
                {2, 4},
                {5, 6}
        };

        int[] arr = new int[n+1];

        for(int i = 1 ; i <= n ; i++) {
            arr[i]=i;
        }
        Arrays.stream(input).forEach(a -> unionParent(arr, a[0], a[1]));
        Arrays.stream(arr).forEach(a -> System.out.print(findParent(arr,a)+" "));
        System.out.println();
        Arrays.stream(arr).forEach(a -> System.out.print(a+" "));
        System.out.println();
    }

    //find
    public static int findParent(final int[] arr,  final int a) {
        if(arr[a] != a) {
            return findParent(arr, arr[a]);
        }
        return a;
    }

    //union
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
