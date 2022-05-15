package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaekJoon_15686_치킨배달 {
    static final int house = 1;
    static final int chicken = 2;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];
        int[][] board = new int[N][N];
        List<Node> houses = new ArrayList<>();
        List<Node> chickens = new ArrayList<>();

        for(int i = 0 ; i < N ; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0 ; j < N ; j++) {
                board[i][j] = input[j];
                if(board[i][j]==house) { houses.add(new Node(i,j)); }
                if(board[i][j]==chicken) { chickens.add(new Node(i,j));}
            }
        }
        selectChicken(0,0, M, new int[M], chickens, houses);
        System.out.println(answer);
    }

    public static void selectChicken(int L, int S, int M, int[] cb, List<Node> chickens, List<Node> houses) {
        if(L==M) {
            answer = Math.min(calculateDistance(cb, chickens, houses), answer);
        } else {
            for(int i = S ; i < chickens.size() ; i++) {
                cb[L]=i;
                selectChicken(L+1, i+1, M, cb, chickens, houses);
            }
        }
    }

    public static int calculateDistance(int[] cb, List<Node> chickens, List<Node> houses) {
        int distance =0;
        for(int i = 0 ; i < houses.size() ; i++) {
            int eachHouse = Integer.MAX_VALUE;
            Node h = houses.get(i);
            for(int j = 0 ; j < cb.length ; j++) {
                Node c = chickens.get(cb[j]);
                eachHouse = Math.min(
                        eachHouse,
                        Math.abs(h.x-c.x)+Math.abs(h.y-c.y)
                );
            }
            distance += eachHouse;
        }
        return distance;
    }

    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
