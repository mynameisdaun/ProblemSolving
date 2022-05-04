package clear;

import java.io.IOException;

public class 싸이클판별 {
    private static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        int n = 3;
        int[][] input = {
                {1, 2},
                {1, 3},
                {2, 3}
        };

        int[] arr = new int[n+1];

        for(int i = 1 ; i <= n ; i++) {
            arr[i]=i;
        }
        boolean cycle = false;

        for(int i = 0 ; i < input.length ; i++) {
            int a = input[i][0];
            int b = input[i][1];
            if(findParent(arr, a)==findParent(arr,b)) {
                cycle=true;
                break;
            } else {
                unionParent(arr, a, b);
            }
        }

        if(cycle) {
            System.out.println("싸이클이 발생하였습니다!");
            return;
        }
        System.out.println("싸이클이 발생ㄴㄴ!");
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
