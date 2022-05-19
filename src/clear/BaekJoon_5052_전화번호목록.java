package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BaekJoon_5052_전화번호목록 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            boolean YES = true;
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for(int i = 0 ; i < arr.length; i++) {
                arr[i]=br.readLine();
            }
            Arrays.sort(arr,(a,b)->a.length()-b.length());
            Set<String> set = new HashSet<>();

            for(int i = 0 ; i < arr.length; i++) {
                String now = arr[i];
                for(int j = 0 ; j < now.length() ; j++) {
                    String copy = now.substring(0,j+1);
                    if(set.contains(copy)) {
                        YES = false;
                    }
                }
                set.add(now);
            }
            if(YES) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
