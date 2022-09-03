package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ_2504_괄호의값 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        try {
            Stack<String> stack = new Stack<String>();
            for (int i = 0; i < arr.length; i++) {
                List<Integer> list = new ArrayList<Integer>();
                if (arr[i].equals(")")) {
                    String pop = stack.pop();
                    while (!pop.equals("(")) {
                        list.add(Integer.parseInt(pop));
                        pop = stack.pop();
                    }
                    int sum = list.stream().reduce(0, Integer::sum);
                    stack.push(String.valueOf(sum != 0 ? sum * 2 : 2));
                } else if (arr[i].equals("]")) {
                    String pop = stack.pop();
                    while (!pop.equals("[")) {
                        list.add(Integer.parseInt(pop));
                        pop = stack.pop();
                    }
                    int sum = list.stream().reduce(0, Integer::sum);
                    stack.push(String.valueOf(sum != 0 ? sum * 3 : 3));
                } else {
                    stack.push(arr[i]);
                }
            }
            System.out.println(stack.stream().mapToInt(Integer::parseInt).sum());
        } catch (Exception e) {
            System.out.println("0");
        }
    }
}
