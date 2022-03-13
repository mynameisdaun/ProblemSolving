package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 동전교환 {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        동전교환 main = new 동전교환();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String[] input2 = br.readLine().split(" ");
        String input3 = br.readLine();

        int N = Integer.parseInt(input1);
        int[] arr = Arrays.stream(input2).mapToInt(Integer::parseInt).sorted().toArray();
        int money = Integer.parseInt(input3);
        main.DFS(0, 0, money, arr);
        System.out.println(answer);
    }

    void DFS(int L, int S, int money, int[] arr) {
        if(S > money || L >= answer) return;
        if(S==money) {
            answer = Math.min(answer,L);
        } else {
            for(int i = arr.length-1 ; i >=0 ; i--) {
                DFS(L+1, S+arr[i], money, arr);
            }
        }
    }

}
