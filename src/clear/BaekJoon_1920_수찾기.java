package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_1920_수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int N = 5;
//        int[] arr1 = {4, 1, 5, 2, 3};
//        int M = 5;
//        int[] arr2 = {1, 3, 7, 9, 5};
        Arrays.sort(arr1);


        for(int i = 0 ; i < M ; i ++) {
            int target = arr2[i];
            int start = 0;
            int end = N-1;
            boolean flag = false;
            while(start<=end) {
                int mid = (start + end) / 2;
                //System.out.println(mid);
                if(arr1[mid] < target) {
                    start = mid + 1;
                    continue;
                }
                if(arr1[mid] > target) {
                    end = mid - 1;
                    continue;
                }
                if(arr1[mid]==target) {
                    flag = true;
                    break;
                }
            }
            System.out.println(flag? 1 : 0);
        }


    }


}
