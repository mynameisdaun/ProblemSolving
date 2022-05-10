package challenging;

import java.io.IOException;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = 5;
        int[] arr = {3, 2, 1, 1, 9};
        int sum = Arrays.stream(arr).sum();
        boolean[] money = new boolean[sum+1];
        Arrays.sort(arr);

        for(int i = 0 ; i < N ; i++) {
            System.out.println(arr[i]);
            money[arr[i]]= true;
            for(int j = 1 ; j <= sum ; j++) {
                if(j+arr[i]<=sum&&money[j]) money[j+arr[i]] = true;
            }
        }

        for(int i = 1; i <= sum ; i++) {
                System.out.println(i+" "+money[i]);
            }
        }
    }
