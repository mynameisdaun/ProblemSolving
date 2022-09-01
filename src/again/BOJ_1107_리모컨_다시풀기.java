package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1107_리모컨_다시풀기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> brokenSet = new HashSet<>();
        Set<Integer> memo = new HashSet<>();
        int start = 100;
        int target = Integer.parseInt(br.readLine());
        int broken = Integer.parseInt(br.readLine());
        if (broken > 0) {
            int[] input =
                    Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < input.length; i++) {
                brokenSet.add(input[i]);
            }
        }
        System.out.println(brokenSet);
        System.out.println(BFS(start, target, brokenSet, memo));
    }

    public static int BFS(int start, int target, Set<Integer> brokenSet, Set<Integer> memo) {
        Queue<Node> queue = new LinkedList<Node>();
        for(int i = 0 ; i <=9 ; i++) {
            if(!brokenSet.contains(i)) {
                memo.add(i);
                queue.offer(new Node(i,1));
            }
        }
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            System.out.println("number: "+now.getNumber()+" depth: "+now.getDepth()) ;
            if (now.getNumber() == target) {
                return now.getDepth();
            }
            
            for (int i = 0; i <= 9; i++) {
                int next = Integer.parseInt(now.getNumber()+""+i);
                if (!brokenSet.contains(i) && !memo.contains(next) && next <= target+10) {
                    System.out.println("next: "+next);
                    memo.add(next);
                    queue.offer(new Node(next, now.getDepth()+1));
                }
            }
            // + 1
            int plusOne = now.getNumber() + 1;
            if(!memo.contains(plusOne)) {
                memo.add(plusOne);
                queue.offer(new Node(plusOne, now.getDepth() + 1));
            }
            int minusOne = now.getNumber() - 1;
            if(minusOne>0&&!memo.contains(minusOne)) {
                memo.add(minusOne);
                queue.offer(new Node(minusOne, now.getDepth() + 1));
            }
        }
        return 0;
    }

    static class Node {
        private int number;
        private int depth;

        public Node(int number, int depth) {
            this.number = number;
            this.depth = depth;
        }

        public int getNumber() {
            return number;
        }

        public int getDepth() {
            return depth;
        }
    }
}
