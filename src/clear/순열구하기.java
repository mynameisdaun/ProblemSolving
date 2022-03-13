package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 순열구하기 {

    public static void main(String[] args) throws IOException {
        순열구하기 main = new 순열구하기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] input2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int N = input1[0];
        int M = input1[1];
        main.DFS(0, N, M, input2, new int[M], new boolean[N]);
    }

    void DFS(int L, int N, int M, int[] arr, int[] print, boolean[] check) {
        if(L==M) {
            for(int i = 0 ; i < print.length ; i ++) {
                System.out.print(print[i]+" ");
            }
            System.out.println();
        } else {
            for(int i = 0 ; i < arr.length ; i ++) {
                if(!check[i]) {
                    check[i] = true;
                    print[L] = arr[i];
                    DFS(L+1, N, M, arr, print, check);
                    check[i] = false;
                }
            }
        }
    }
}
