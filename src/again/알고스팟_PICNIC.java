package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알고스팟_PICNIC {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        알고스팟_PICNIC main = new 알고스팟_PICNIC();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int tcase = Integer.parseInt(br.readLine());;
        int tcase = 1;

        while(tcase-- > 0) {
//            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            answer = 0;
            int n = 4;
            int m = 6;
            int[] arr = {0, 1, 1, 2, 2, 3, 3, 0, 0, 2, 1, 3};
//            int n = input[0];
//            int m = input[1];
//            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(main.solution(n, m, arr));
        }
    }

    public int solution(int n, int m, int[] arr) {
        //base
        if(m==0) return answer;
        if(n==2&&m==1) return answer=1;

        int[][] board = new int[m][2];
        for(int i = 0 ; i < m ; ++i) {
            board[i][0] = arr[i*2];
            board[i][1] = arr[i*2+1];
        }
        int[][] cb = new int[n/2][2];
        DFS(0,0, cb, n, m, board);
        return answer;
    }

    public void DFS(int L, int S, int[][] cb, int n, int m, int[][] board) {
        if(L==n/2) {
            if(Arrays.stream(cb).flatMapToInt(x->Arrays.stream(x)).distinct().count()==n) { answer++; }
        } else {
            for(int i = S ; i < m ; ++i) {
                cb[L]=board[i];
                DFS(L+1, i+1, cb, n, m, board);
            }
        }
    }

}

