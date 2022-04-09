package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long start = System.currentTimeMillis();
        //System.out.println(start);
        DFS(0, N, new int[N], new boolean[N]);
        System.out.println(answer);
        long end = System.currentTimeMillis();
        //System.out.println(end);
        //System.out.println(end-start);
    }
    public static void DFS(int L, int N, int[] pm, boolean[] visited) {
        if(L==N) {
//            for(int i = 0 ; i < N ; i ++) {
//               int queen = pm[i];
//                int rightD = queen;
//                int leftD = queen;
//                for(int j = i+1; j < N ; j++) {
//                    if(++rightD == pm[j]) return;
//                    if(--leftD == pm[j]) return;
//                }
//            }
            answer++;
        } else {
            for(int i = 0 ; i < N ; i ++) {
                boolean pass = true;
                if(!visited[i]) {
                    int queen = i;
                    int leftD = i;
                    int rightD = i;
                    for(int j = L-1 ; j >= 0 ; --j) {
                        if(++rightD == pm[j] || --leftD == pm[j]) {
                            pass=false;
                            break;
                        }
                    }
                    if(!pass) continue;
                    visited[i]=true;
                    pm[L]=i;
                    DFS(L+1, N, pm, visited);
                    visited[i]=false;
                }
            }
        }
    }
}

