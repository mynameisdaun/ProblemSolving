package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 조합구하기 {

    public static void main(String[] args) throws IOException {
        조합구하기 main = new 조합구하기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input1[0];
        int M = input1[1];
        main.DFS(0, 1, N, M, new boolean[N+1], new int[M+1]);
    }

    void DFS(int L, int S, int N, int M, boolean[] check, int[] print) {
        if(L==M) {
            for(int i = 0 ; i < M ; i ++) {
                System.out.print(print[i]+" ");
            }
            System.out.println();
        } else {
            for(int i = S ; i <= N ; i ++) {
                if(!check[i] && L < i) {
                    check[i] = true;
                    print[L] = i;
                    DFS(L+1, i, N, M, check, print);
                    check[i] = false;
                }
            }
        }
    }


}
