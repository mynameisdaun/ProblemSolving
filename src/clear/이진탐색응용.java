package clear;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 이진탐색응용 {
    public static int count =0;
    public static Set<Integer> set = new HashSet<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 4;
        int M = 6;
        int[] arr = {19, 15, 10, 17};
        Arrays.sort(arr);
        binarySort(arr, M, 0, arr[arr.length-1]);
        System.out.println(answer);
    }

    public static void binarySort(int[] arr, int M, int start, int end) {
        int mid = (start + end) / 2;
        if(start <= end) {
            int sum = riceCake(arr, mid);
            if(sum >= M) {
                answer = mid;
                binarySort(arr, M, mid+1, end);
            } else {
                binarySort(arr, M, start, mid-1);
            }
        }
    }

    public static int riceCake(int[] arr, int mid) {
        int sum = 0;
        for(int i = 0 ; i < arr.length; i ++) {
            if(arr[i]>mid) {
                sum += arr[i]-mid;
            }
        }
        return sum;
    }
}
