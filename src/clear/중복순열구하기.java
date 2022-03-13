package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 중복순열구하기 {

    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        중복순열구하기 main = new 중복순열구하기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }

    void DFS (int L, int N, int M, int[] arr) {
        if(L==M) {
            for(int i = 0 ; i < arr.length ; i ++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        } else {
            for(int i = 1 ; i <= N ; i ++) {
                arr[L]=i;
                DFS(L+1, N, M, arr);
            }
        }
    }

}
