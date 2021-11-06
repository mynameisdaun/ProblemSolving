package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BaekJoon_14889_링크스타트 {

    static int squad[][];
    static int N;
    static int visited[];
    static int answer = Integer.MAX_VALUE ;
    static int totalScore = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        squad = new int[N][N];
        visited = new int[N/2];

        for(int i = 0 ; i < N ; i++) {
            String[] arr = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++) {
                squad[i][j] = Integer.parseInt(arr[j]);
                totalScore += squad[i][j];
            }
        }
        //System.out.printf("totalScore: "+totalScore+"\n");
        DFS(0, 0);
        System.out.println(answer);
    }

    static void DFS(int L, int S) {
        if(L==N/2) {
            int myteam = 0;
            int opposite = 0;
            Set<Integer> set = new HashSet<Integer>();

            for(int x: visited) {
                set.add(x);
            }


            for(int i = 0 ; i < N ; i ++) {
                for(int j = 0 ; j < N ; j ++) {
                    if(i==j) continue;
                    if(set.contains(i)&&set.contains(j)) {
                        myteam += squad[i][j];
                    } else if(!set.contains(i)&&!set.contains(j)) {
                        opposite += squad[i][j];
                    }
                }
            }

//            System.out.printf("totalScore: "+totalScore+"\n");
//            System.out.printf("our: "+myteam+"\n");
//            System.out.printf("enemy: "+opposite+"\n");
            answer = Math.min(Math.abs(myteam - opposite),answer);

        }else {
            for(int i = S ; i < N ; i ++) {
                visited[L] = i;
                DFS(L+1, i+1);
            }

        }
    }
}



