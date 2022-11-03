package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BOJ_11509 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(arr).forEach(a->map.put(a,0));
        int arrow = 0;
        for (int i = 0; i < arr.length; i++) {
            if(map.get(arr[i])>0) {
                map.put(arr[i], map.get(arr[i])-1);
            } else {
                arrow++;
            }
            map.put(arr[i]-1,map.getOrDefault(arr[i]-1,0)+1);
        }
        System.out.println(arrow);
    }
}
