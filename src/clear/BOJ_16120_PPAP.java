package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_16120_PPAP {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='P') {
                stack.push('P');
            } else {
                if(stack.size()<2 || i+1 >= str.length() || str.charAt(i+1) != 'P'){
                    System.out.println("NP");
                    return;
                }
                for (int j = 0; j < 2; j++) {
                    if(stack.pop()!='P') {
                        System.out.println("NP");
                        return;
                    }
                }
                stack.push('P');
                i++;
            }
        }
        if(stack.size() == 1 && stack.pop() =='P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}

/*
PPAP


* */

