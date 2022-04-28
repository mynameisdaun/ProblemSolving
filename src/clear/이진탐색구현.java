package clear;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 이진탐색구현 {
    public static int count =0;
    public static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 5;
        int[] A = {8, 3, 7, 9, 2};
        int M = 3;
        int[] B = {5, 7, 9};
        Arrays.sort(A);

        for(int i = 0 ; i < B.length ; i ++) {
            System.out.println(binarySort(A, 0, A.length-1, B[i]));
        }
    }

    public static boolean binarySort(int[] A, int start, int end, int target) {
        int mid = (start + end) / 2;
        if(start <= end) {
            if(target == A[mid]) {
                return true;
            }
            if(target < A[mid]) {
                return binarySort(A, start, mid-1, target);
            }
            if(target > A[mid]) {
                return binarySort(A, mid+1,end,target);
            }
        }
        return false;
    }
}
