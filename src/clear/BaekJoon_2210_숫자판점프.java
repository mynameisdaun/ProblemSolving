package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BaekJoon_2210_숫자판점프 {

    static int N = 5;
    static int[][]board = new int[N][N];
    static Set<Integer> answer = new HashSet<Integer>();
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static char[] sixDigit = new char[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < N; i ++) {
            String[]arr = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++) {
                board[i][j] = Integer.parseInt(arr[j]);
            }
        }

        for(int i = 0 ; i < N*N ; i ++) {
            int x = i / N;
            int y = i % N;
            DFS(0,x,y);
        }

        //answer.forEach(a -> System.out.println(a));
        System.out.println(answer.size());

    }
    static void DFS(int L,int x, int y) {
        if(L==6) {
            String str = String.valueOf(sixDigit);
            answer.add(Integer.parseInt(str));

        } else {
            for(int i = 0 ; i < 4 ; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0&&nx<N&&ny>=0&&ny<N) {
                    sixDigit[L] = Character.forDigit(board[nx][ny],10);
                    //System.out.println(sixDigit[L]);
                    DFS(L+1,nx,ny);
                }
            }

        }

    }



}


