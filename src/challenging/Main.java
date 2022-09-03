package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        if (arr[1] < 5) {
            System.out.println(answer);
            return;
        }
        if(arr[1]==26) {
            System.out.println(arr[0]);
            return;
        }
        boolean[] visited = new boolean[26];
        visited['a'-97]=true;
        visited['n'-97]=true;
        visited['t'-97]=true;
        visited['i'-97]=true;
        visited['c'-97]=true;
        int k = arr[1] - 5;
        String[] words = new String[arr[0]];
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < arr[0]; i++) {
            words[i] = br.readLine().replaceAll("a|n|t|i|c", "");
//            if (words[i].equals(""))
//                answer++;
        }
        DFS(0, 0, k, new String[k], words, visited);
        System.out.println(answer);
    }

    public static void DFS(int L, int s, int k, String[] cb, String[] words, boolean[] visited) {
        if (L == k) {
            int sum = 0;
            for (int i = 0; i < words.length; i++) {
                boolean isValid = true;
                String word = words[i];
                for(int j = 0 ; j < word.length() ; j++) {
                    if(!visited[word.charAt(j) - 97 ]) {
                        isValid=false;
                        break;
                    }
                }
                if(isValid) {
                    sum++;
                }
            }
            answer = Math.max(sum, answer);
        } else {
            for (int i = s; i < 26; i++) {
                if(!visited[i]) {
                    visited[i]=true;
                    DFS(L + 1, i + 1, k, cb, words, visited);
                    visited[i]=false;
                }
            }
        }
    }
}

