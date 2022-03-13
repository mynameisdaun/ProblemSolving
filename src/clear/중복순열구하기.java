package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);
        main.DFS(0, N, M, new int[M]);
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
