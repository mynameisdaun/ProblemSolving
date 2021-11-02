package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int L;
    static int C;
    static char[] charArr;
    static char[] answer;
    static boolean[] visited;
    static Set<Character> vowel = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        L = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        charArr = br.readLine().replace(" ","").toCharArray();
        visited = new boolean[C];
        answer = new char[L];
        Arrays.sort(charArr);

        vowel.add('a');vowel.add('e');vowel.add('i');
        vowel.add('o');vowel.add('u');

        DFS(0, 0, 0);
    }

    static void DFS(int D, int v, int c) {

        if(D==L) {
            if(v>=1&&c>=2)
                System.out.println(String.valueOf(answer));
        } else {

            for(int i = 0 ; i < C ; i ++) {
                if(!visited[i]){
                    if( D>=1 && answer[D-1] > charArr[i]) {
                        continue;
                    }
                    visited[i]=true;
                    answer[D] = charArr[i];

                    if(vowel.contains(charArr[i])) {
                        DFS(D+1, v+1, c);
                    } else {
                        DFS(D+1, v, c+1);
                    }
                    visited[i]=false;
                }
            }
        }
    }


}



