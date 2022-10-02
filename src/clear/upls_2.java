package clear;

import java.io.IOException;
import java.util.Stack;

public class upls_2 {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        //int[] arr = new int[]{112, 1814, 121, 1481, 1184};
        //String str = "2(3(hi)co)";
        String str = "10(p)";
        System.out.println(solution.solution(str));
    }

    static class Solution {
        public String solution(String compressed) {
            return recursive(compressed);
        }
    }

    static String recursive(String str) {
        StringBuilder answer = new StringBuilder();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))&&Character.isDigit(str.charAt(i+1))) {
                num.append(str.charAt(i));
                continue;
            }

            if(Character.isDigit(str.charAt(i))&&!Character.isDigit(str.charAt(i+1))) {
                num.append(str.charAt(i));
                String curr = num.toString();
                num = new StringBuilder();
                Stack<Character> stack = new Stack<>();
                System.out.println(curr);
                int repeat = Integer.parseInt(curr);
                StringBuilder sb = new StringBuilder();
                for (int j = i+1; j < str.length(); j++) {
                    sb.append(str.charAt(j));
                    if(str.charAt(j)=='(') {
                        stack.push('(');
                    } else if(str.charAt(j)==')') {
                        stack.pop();
                        if(stack.isEmpty()) break;
                    }
                }
                String uncomp = recursive(sb.toString().substring(1, sb.length()-1));
                for (int j = 0; j < repeat; j++) {
                    answer.append(uncomp);
                }
                i+=sb.length();
            } else {
                answer.append(str.charAt(i));
            }
        }
        return answer.toString();
    }
}

