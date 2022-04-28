package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 숫자카드게임 {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 3;
        int M = 3;
        int[][] board = {
                {3, 1, 2},
                {4, 1, 4},
                {2, 2, 2}
        };
        int max = Integer.MIN_VALUE;
        for(int[] arr : board) {
            Arrays.sort(arr);
            max = Math.max(arr[0], max);
        }
        System.out.println(max);
    }
}

