package challenging;

import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int INF = 98765431;
        int answer = 0;
        int[][] distance = new int[N+1][N+1];

        for(int i = 1 ; i <= N ;i++) {
            for(int j = 1; j <=N ; j++) {
                if(i==j) {
                    distance[i][j] = 0;
                    continue;
                }
                distance[i][j]=INF;
            }
        }

        for(int[] arr : road) {
            int x = arr[0];
            int y = arr[1];
            int d = arr[2];
            distance[x][y]=Math.min(d, distance[x][y]);
            distance[y][x]=Math.min(d, distance[y][x]);
        }

        for(int k = 1; k <= N ; k++) {
            for(int i = 1; i <= N ; i++) {
                for(int j = 1; j <=N; j++) {
                    distance[i][j] = Math.min(distance[i][j],
                            distance[i][k]+distance[k][j]);
                }
            }
        }
        for(int i = 1 ; i <= N ; i++) {
            if(distance[1][i]<=K) answer++;
        }
        return answer;
    }
}
