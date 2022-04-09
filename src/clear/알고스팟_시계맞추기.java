package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알고스팟_시계맞추기 {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int[] watches = {12, 6, 6, 6, 6, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};
        //int[] watches = {12, 9, 3, 12, 6, 6, 9, 3, 12, 9, 12, 9, 12, 12, 6, 6};
        int[][] switches = new int[][]{
                 {0,1,2} // 0
                ,{3,7,9,11} // 1
                ,{4, 10, 14, 15} // 2
                ,{0,4,5,6,7} // 3
                ,{6,7,8,10,12} // 4
                ,{0,2,14,15} //5
                ,{3,14,15} //6
                ,{4,5,7,14,15} // 7
                ,{1,2,3,4,5} // 8
                ,{3,4,5,9,13}//9
        };
        int tcase = Integer.parseInt(br.readLine());
        while(tcase-->0) {
            answer = Integer.MAX_VALUE;
            int[] watches = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            DFS(0, new int[10], switches, watches);
            if(answer==Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(answer);
            }
        }
    }

    public static void DFS(int L, int[] pm, int[][] switches, int[] watches) {
        if(L==10) {
            int[] copy = Arrays.copyOfRange(watches, 0, 16);
            for(int switchNumber = 0 ; switchNumber < 10 ; switchNumber++) {
                for(int watch : switches[switchNumber]) {
                    copy[watch] += pm[switchNumber]*3;
                    if(copy[watch] > 12) {
                        copy[watch] -= 12;
                    }
                }
            }
            if(isTwelve(copy)) {
                answer = Math.min(countAnswer(pm),answer);
            }
        }else {
            for(int i = 0 ; i <=3 ; i ++) {
                pm[L]=i;
                DFS(L+1, pm, switches, watches);
            }
        }
    }

    public static boolean isTwelve(int[] copy) {
        for(int i = 0 ; i < 16 ; ++i) {
            if(copy[i] != 12) return false;
        }
        return true;
    }

    public static int countAnswer(int[] pm) {
        int sum =0;
        for(int i = 0 ; i < 10 ; ++i) {
            sum += pm[i];
        }
        return sum;
    }

}

