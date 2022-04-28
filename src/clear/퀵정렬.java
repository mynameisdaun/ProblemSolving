package clear;

import java.io.IOException;

public class 퀵정렬 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {5, 3, 9, 2, 8, 1, 4, 7, 6};
        quickSort(arr, 0, arr.length-1);
        for(int x : arr) {
            System.out.print(x+" ");
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }
        int pivot = start;
        int left = start+1;
        int right = end;
        while(left <= right) {
            System.out.println("pivot: "+pivot+" left: "+left+" right: "+right);
            while(left <= end && arr[left] <= arr[pivot]) {
                left++;
            }
            while(right > start && arr[right] >= arr[pivot]) {
                right--;
            }
            if(left > right) {
                int temp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = temp;
                for(int x : arr) {
                    System.out.print(x+" ");
                }
                System.out.println();
            } else {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                for(int x : arr) {
                    System.out.print(x+" ");
                }
                System.out.println();
            }
        }
        quickSort(arr, start, right-1);
        quickSort(arr, right+1, end);
    }
}

