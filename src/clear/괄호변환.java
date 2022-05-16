package clear;

import java.util.Stack;

class 괄호변환 {

    public String solution(String p) {
        return DFS(p);
    }

    public String DFS(String p) {
        if(p.length()==0) return "";
        String u="";
        String v="";
        for(int i = 1 ; i <= p.length() ; i++) {
            u = p.substring(0,i);
            if(isBalanced(u)) {
                v = p.substring(i);
                break;
            }
        }
        if(isCorrect(u)) {
            return u + DFS(v);
        } else {
            StringBuilder answer = new StringBuilder();
            answer.append("(")
                    .append(DFS(v))
                    .append(")");
            for(int i = 1 ; i < u.length()-1;i++) {
                if(u.charAt(i)=='(') {
                    answer.append(')');
                }else {
                    answer.append('(');
                }
            }
            return answer.toString();
        }
    }

    public boolean isBalanced(String s) {
        String deleted = s.replaceAll("\\(","");
        return s.length() == deleted.length() * 2;
    }

    public boolean isCorrect(String s) {
        Stack<String> stack = new Stack<String>();
        String[] arr = s.split("");
        for(int i = 0 ; i < arr.length ; i++) {
            if("(".equals(arr[i])) {
                stack.push(arr[i]);
            } else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
