package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int N = input.length;
        DFS(0, new int[N],new boolean[N], N, input);
        System.out.println(answer);
        String str = "1";
        Calendar cal = Calendar.getInstance();
        Map<String, String> map = new HashMap<>();

    }

    static void DFS(int L, int[] pm, boolean[] visited, int N, int[] arr) {
        if(L==N) {
            StringBuilder sb = new StringBuilder();
            for(int x : pm) {
                sb.append(x);
            }
            int tmp = Integer.parseInt(sb.toString());
            if(tmp%30==0) {
                answer = Math.max(tmp,answer);
            }
        } else {
            for(int i = 0 ; i < arr.length ; i ++) {
                if(!visited[i]) {
                    visited[i]=true;
                    pm[L]=arr[i];
                    DFS(L+1, pm, visited, N, arr);
                    visited[i]=false;
                }
            }
        }
    }
}

