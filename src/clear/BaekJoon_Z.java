package clear;//package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BaekJoon_Z {

    static int N;
    static int r;
    static int c;
    static long S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        N = Integer.parseInt(arr[0]);
        r = Integer.parseInt(arr[1]);
        c = Integer.parseInt(arr[2]);
        S = 0;


        while(N > 0) {
            checkQuadrant();
        }

//        System.out.println("N: "+N);
//        System.out.println("r: "+r);
//        System.out.println("c: "+c);
//        System.out.println("S: "+S);
        System.out.println(S);
    }

    static void checkQuadrant() {
        long NumberOfRow = (long) Math.pow(2,N);
        long NumberOfCol = (long) Math.pow(2,N);
        long StartPoint  = (long) Math.pow(2,N-1) * (long) Math.pow(2,N-1);

        if(r < NumberOfRow / 2) {
            //2사분면
            if(c < NumberOfCol /2) {
                //변경없음
            }
            //1사분면
            else {
                c -= (int) Math.pow(2, N-1);
                S  += StartPoint;
            }
        } else {
            //3사분면
            if(c < NumberOfCol /2) {
                r -= (int) Math.pow(2, N-1);
                S += StartPoint * 2;
            }
            //4사분면
            else {
                r -= (int) Math.pow(2, N-1);
                c -= (int) Math.pow(2, N-1);
                S += StartPoint * 3;
            }
        }
        N--;
    }





}