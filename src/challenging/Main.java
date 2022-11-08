package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

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
        long onePlane = 50L;
        long twoPlane = 100L;
        long threePlane = 150L;
        for (int i = 0; i < 6; i++) {
            onePlane = Math.min(onePlane, arr[i]);
            for (int j = i + 1; j < 6; j++) {
                if (i + j == 5) continue;
                twoPlane = Math.min(twoPlane, arr[i] + arr[j]);
                for (int k = j + 1; k < 6; k++) {
                    if (i + k == 5 || j + k == 5) continue;
                    threePlane = Math.min(threePlane, arr[i] + arr[j] + arr[k]);
                }
            }
        }
        answer += 4 * threePlane;
        answer += (4 + 8 * (n - 2)) * twoPlane;
        answer += (4 * (n - 2) + (5 * (n - 2) * (n - 2))) * onePlane;
        System.out.println(answer);
    }
}
