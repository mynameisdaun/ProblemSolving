package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1041_주사위 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long answer = 0L;
        if (n == 1) {
            Arrays.sort(arr);
            for (int i = 0; i < 5; i++) {
                answer += arr[i];
            }
            System.out.println(answer);
            return;
        }
        long onePlane = Integer.MAX_VALUE;
        long twoPlane = Integer.MAX_VALUE;
        long threePlane = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            onePlane = Math.min(onePlane, arr[i]);
            for (int j = i + 1; j < 6; j++) {
                if (i + j != 5) {
                    twoPlane = Math.min(twoPlane, arr[i] + arr[j]);
                }
                for (int k = j + 1; k < 6; k++) {
                    if (i + j != 5 && i + k != 5 && j + k != 5) {
                        threePlane = Math.min(threePlane, arr[i] + arr[j] + arr[k]);
                    }
                }
            }
        }
        answer += 4L * threePlane;
        answer += 4L * twoPlane;
        answer += Long.valueOf(8L * twoPlane * (n - 2));
        answer += Long.valueOf(4L * onePlane * (n - 2));
        answer += Long.valueOf(5L * onePlane * ((n - 2) * (n - 2)));
        System.out.println(answer);
    }
}
