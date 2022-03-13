package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최대점수구하기 {

    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        최대점수구하기 main = new 최대점수구하기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int timeLimit = Integer.parseInt(input1[1]);
        int[] 점수 = new int[N];
        int[] 시간 = new int[N];
        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split(" ");
            점수[i] = Integer.parseInt(input2[0]);
            시간[i] = Integer.parseInt(input2[1]);
        }
        main.DFS(0,0,0, 점수, 시간, timeLimit);
        System.out.println(answer);
    }

    void DFS(int L, int S, int T, int[] 점수, int[] 시간, int timeLimit) {
        if(T > timeLimit) return ;
        if(L==점수.length) {
            answer = answer > S ? answer : S ;
        } else {
            DFS(L+1, S+점수[L], T+시간[L], 점수, 시간, timeLimit);
            DFS(L+1, S, T, 점수, 시간, timeLimit);
        }
    }
}
