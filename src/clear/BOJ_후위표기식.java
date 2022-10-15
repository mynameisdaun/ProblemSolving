package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_후위표기식 {

    static Map<Integer, String> map = new HashMap<>();
    static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(suffix(br.readLine()));
    }

    public static String suffix(String equation) {
        // () 괄호 재귀로 처리
        List<String> removeParenthesis = new ArrayList<>();

        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '(') {
                Stack<Character> stack = new Stack<>();
                StringBuilder sb = new StringBuilder();
                for (int j = i + 1; j < equation.length(); j++) {
                    if (equation.charAt(j) == '(')
                        stack.push('(');
                    else if (equation.charAt(j) == ')') {
                        if (stack.isEmpty()) {
                            removeParenthesis.add(suffix(sb.toString()));
                            i = j;
                            break;
                        } else {
                            stack.pop();
                        }
                    }
                    sb.append(equation.charAt(j));
                }
            } else {
                removeParenthesis.add(String.valueOf(equation.charAt(i)));
            }
        }
        Stack<String> afterMultiply = new Stack<>();
        for (int i = 0; i < removeParenthesis.size(); i++) {
            if (removeParenthesis.get(i).equals("*") || removeParenthesis.get(i).equals("/")) {
                StringBuilder sb = new StringBuilder(afterMultiply.pop())
                        .append(removeParenthesis.get(i + 1))
                        .append(removeParenthesis.get(i));
                afterMultiply.push(sb.toString());
                i++;
            } else {
                afterMultiply.push(removeParenthesis.get(i));
            }
        }
        Stack<String> reverseOrder = reverseOrder(afterMultiply);
        while (reverseOrder.size() != 1) {
            String a = reverseOrder.pop();
            String op = reverseOrder.pop();
            String b = reverseOrder.pop();
            reverseOrder.push(a + b + op);
        }
        String ans = reverseOrder.pop();
        return ans;
    }

    public static Stack<String> reverseOrder(Stack<String> stack) {
        Stack<String> reverse = new Stack<>();
        while (!stack.isEmpty()) {
            reverse.push(stack.pop());
        }
        return reverse;
    }
}
