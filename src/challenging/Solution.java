package challenging;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    static String[] operators;
    static long answer = Long.MIN_VALUE;
    static String expression;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("100-200*300-500+20"));
    }

    public long solution(String expression) {
        this.expression = expression;
        this.operators = Arrays.stream(expression.split("\\d+")).distinct().filter(a -> a.length() >= 1).toArray(String[]::new);
        연산자우선순위결정(0,new String[operators.length], new boolean[operators.length]);
        return answer;
    }

    static void 연산자우선순위결정(int L, String[] pm, boolean[] visited) {
        if(L==operators.length) {
            answer = Math.max(answer, 연산(expression, pm));
        }else {
            for(int i = 0 ; i < operators.length ; i ++) {
                if(!visited[i]) {
                    visited[i]=true;
                    pm[L]=operators[i];
                    연산자우선순위결정(L+1, pm, visited);
                    visited[i]=false;
                }
            }
        }
    }

    static long 연산(String expression, String[] 연산순서) {
        long tmp = Long.MIN_VALUE;;

        String 수식 = String.copyValueOf(expression.toCharArray());

        String[] numbers = Arrays.stream(수식.split("\\+|\\-|\\*")).toArray(String[]::new);
        String[] operatorSeq = Arrays.stream(수식.split("\\d+")).filter(a->a.length()>=1).toArray(String[]::new);
        Arrays.stream(numbers).collect(Collectors.toList());

        Stack<String> stack = new Stack<String>();
        Queue<String> queue = new LinkedList<String>();

        for(int i = 0 ; i < operatorSeq.length; i++) {
            queue.offer(operatorSeq[i]);
            queue.offer(numbers[i+1]);
        }
        stack.push(numbers[0]);

        List<int[]> list = new ArrayList<int[]>();
        list.stream().sorted((a,b) -> (a[1]-a[0])-(b[1]-b[0])).findFirst().get();
        list.stream().distinct().count();
        for(String 연산자 : 연산순서) {

            while(queue.size()>1) {
                String number = stack.pop();
                String operator = queue.poll();
                String nextNumber = queue.poll();

                if(operator.equals(연산자)) {
                    stack.push(계산(number, nextNumber, operator));
                } else {
                    stack.push(number);
                    stack.push(operator);
                    stack.push(nextNumber);
                }
            }

            if(stack.size()==1) {
                tmp = Math.max(Math.abs(Long.parseLong(stack.pop())),tmp);
            } else {
                queue = new LinkedList<>(stack.subList(0,stack.size()));
                stack.clear();
                stack.push(queue.poll());
            }
        }
        return tmp;
    }

    static String 계산(String number, String nextNumber, String operator) {
        StringBuilder sb = new StringBuilder();
        long first = Long.parseLong(number);
        long second = Long.parseLong(nextNumber);
        if(operator.equals("+")) {
            return sb.append(first+second).toString();
        }
        if(operator.equals("-")) {
            return sb.append(first-second).toString();
        }
        if(operator.equals("*")) {
            return sb.append(first*second).toString();
        }
        return "";
    }
}
