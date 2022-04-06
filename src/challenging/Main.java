package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    static long[] arr;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int A = input[0];
        int B = input[1];
        int C = input[2];
        System.out.println(power(A,B,C));
    }

    public static long power(int A, int B, int C) {
        if(B==1) {
            return A % C;
        } else {
            long temp = power(A, B/2, C);
            if(B%2==0) {
                return ((temp % C) * (temp % C)) % C;
            }
            return (((temp%C * temp%C) % C) * (A % C)) % C ;
        }
    }
}

