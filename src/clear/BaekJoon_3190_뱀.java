package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_3190_뱀 {
    static int[] head = {1,1};
    static Queue<int[]> queue = new LinkedList<>();
    static final int apple = 4;
    static final int snake = 5;
    static int direction = 0;
    static final int[] dx = {0, 1,  0, -1};
    static final int[] dy = {1, 0, -1,  0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] board = new int[N+1][N+1];
        for(int i = 0 ; i < K ; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            board[input[0]][input[1]] = apple;
        }
        int L = Integer.parseInt(br.readLine());
        Map<Integer, String> map = new HashMap<>();
        for(int i = 0; i < L ; i++) {
            String[] input = br.readLine().split(" ");
            map.put(Integer.parseInt(input[0]), input[1]);
        }
        queue.offer(new int[]{1, 1});
        while(true) {
            count++;
            if(!move(board, N)) {
                break;
            }
            if(map.containsKey(count)) {
                changeDirection(map.get(count));
            }
        }
        System.out.println(count);
    }
    static void changeDirection(String d) {
        if("D".equals(d)) {
            direction = (direction + 1) % 4 ;
        }
        if("L".equals(d)) {
            direction = (direction ==0 ) ? 3 : direction -1 ;
        }
    }

    static boolean move (int[][] board, int N) {
        int nx = head[0] + dx[direction];
        int ny = head[1] + dy[direction];
        if(nx>=1&&nx<=N&&ny>=1&&ny<=N&&board[nx][ny]!=snake) {
            head[0]=nx;
            head[1]=ny;
            queue.offer(new int[]{nx, ny});
            if(board[nx][ny] != apple) {
                int[] tail = queue.poll();
                board[tail[0]][tail[1]]=0;
            }
            board[head[0]][head[1]] = snake;
            return true;
        }
        return false;
    }
}
