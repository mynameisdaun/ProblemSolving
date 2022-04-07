package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        long B = Long.parseLong(input1[1]);
        int[][] A = new int[N][N];
        for(int i = 0 ; i < N ; i ++) {
            String[] input2 = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++) {
                A[i][j] = Integer.parseInt(input2[j]) % 1000;
            }
        }
        int[][] C = 거듭제곱(A,B,N);
        printMatrix(C,N);
    }

    public static int[][] 거듭제곱(int[][] A, long B, int N) {
        if(B==1) {
            return A;
        }
        if(B==2) {
            return matrixMultiply(A,A,N,N,N);
        }
        int[][] C = 거듭제곱(A,B/2,N);
        if(B % 2 == 0) {
            return matrixMultiply(C, C, N, N, N);
        }
        return matrixMultiply(matrixMultiply(C, C, N, N, N),A,N,N,N);
    }

    public static int[][] matrixMultiply(int[][] A, int[][] B, int N, int M,int K) {
        int[][] C = new int[N][K];
        for(int i = 0 ; i < N ; ++i) {
            for(int j = 0 ; j < K ; ++j) {
                int temp = 0;
                for(int k = 0 ; k < M ; ++k) {
                    temp += (A[i][k]%1000) * (B[k][j]%1000);
                }
                C[i][j] = temp%1000;
            }

        }
        return C;
    }

    public static void printMatrix(int[][] A, int N) {
        for(int i = 0 ; i < N ; ++i)  {
            for(int j = 0 ; j < N ; ++j) {
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
    }
}

