package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BOJ_1783_병든나이트 {
    //1: 2칸위로 1칸 오른쪽
    static int[] dx = {2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1};
    static int top;
    static int col;
    static int bottom=1;
    static boolean[] visited = new boolean[4];
    static int answer = 0;
    static int INF = 2_000_000_000;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        top = input[0];
        col = input[1];

        int x = 1;
        int y = 1;

        while(true) {
            int[] values = new int[5];
            values[1] = moveFirst(x,y);
            values[2] = moveSecond(x,y);
            values[3] = moveThird(x,y);
            values[4] = moveFourth(x,y);
            int maxIndex = 0;
            int maxValue = 0;
            for(int i = 1 ; i <=4 ; i++){
                if(values[i]>maxValue) {
                    maxValue = values[i];
                    maxIndex = i;
                }
            }

            answer += maxValue;
            


            if(maxValue==0) break;
        }
        System.out.println(answer);
    }

    public static int moveFirst(int x, int y) {
        int topRoom = (top - x) / 2;
        int colRoom = (col - y);
        return  Math.min(topRoom, col);
    }

    public static int moveSecond(int x, int y) {
        int topRoom = (top - x);
        int colRoom = (col - y) / 2;
        return Math.min(topRoom, col);
    }

    public static int moveThird(int x, int y) {
        int bottomRoom = (x-0) / 2;
        int colRoom = (col - y);
        return Math.min(bottomRoom, col);
    }

    public static int moveFourth(int x, int y) {
        int bottomRoom = (x-0);
        int colRoom = (col - y) / 2;
        return Math.min(bottomRoom, col);
    }



}
