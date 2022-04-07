package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);
        int[][] A = new int[N][M];
        for(int i = 0 ; i < N ; i ++) {
            String[] input2 = br.readLine().split(" ");
            for(int j = 0 ; j < M ; j ++) {
                A[i][j] = Integer.parseInt(input2[j]);
            }
        }
        String[] input3 = br.readLine().split(" ");
        int K = Integer.parseInt(input3[1]);
        int[][] B = new int[M][K];
        for(int i = 0 ; i < M ; i ++) {
            String[] input4 = br.readLine().split(" ");
            for(int j = 0 ; j < K ; j ++) {
                B[i][j] = Integer.parseInt(input4[j]);
            }
        }
        int[][] C = matrixMultiply(A, B, N, M, K);
        for(int i = 0 ; i < N ; ++i)  {
            for(int j = 0 ; j < K ; ++j) {
                System.out.print(C[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixMultiply(int[][] A, int[][] B, int N, int M,int K) {
        int[][] C = new int[N][K];
        for(int i = 0 ; i < N ; ++i) {
            for(int j = 0 ; j < K ; ++j) {
                for(int k = 0 ; k < M ; ++k) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

}

