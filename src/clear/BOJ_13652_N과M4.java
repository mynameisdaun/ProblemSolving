package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_13652_N과M4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        DFS(0,1, new int[m], n, m);
    }

    public static void DFS(int L, int s, int[] cb, int n, int m ) {
        if(L==m) {
            for(int x : cb) System.out.print(x + " ");
            System.out.println();
        } else {
            for(int i = 1 ; i <= n ; i++) {
                if( L==0 || cb[L-1] <= i) {
                    cb[L]=i;
                    DFS(L+1, i+1, cb, n, m);
                }
            }
        }
    }
}
