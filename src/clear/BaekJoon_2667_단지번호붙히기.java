package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BaekJoon_2667_단지번호붙히기 {


    static int N;
    static int[][] BOARD;
    static int NumberOfArea = 0;
    static Map<Integer, Integer> widthMap = new HashMap<Integer, Integer>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        BOARD = new int[N][N];


        for(int i = 0 ; i < N ; i ++) {
            String[] arr = br.readLine().split("");
            for(int j = 0 ; j < N ; j++) {
                BOARD[i][j] = Integer.parseInt(arr[j]);
            }
        }


        for(int i = 0 ; i < N; i ++) {
            for(int j = 0 ; j < N ; j ++) {
                if(BOARD[i][j]==1){
                    BOARD[i][j]=0;
                    BFS(i,j ,++NumberOfArea);
                }
            }
        }

        System.out.println(NumberOfArea);
        widthMap.values().stream().sorted().forEach(width -> System.out.println(width));

    }

    static void BFS(int startX, int startY, int NumberOfWidth) {
        Queue<Integer[]> queue = new LinkedList<Integer[]>();
        queue.offer(new Integer[] {startX,startY});
        int count = 0;

        while(!queue.isEmpty()) {
            count++;
            Integer[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            for(int i = 0 ; i < 4 ; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0&&nx<N&&ny>=0&&ny<N&&BOARD[nx][ny]==1) {
                    BOARD[nx][ny] = 0;
                    queue.add(new Integer[] {nx,ny});
                }
            }
        }

        widthMap.put(NumberOfWidth,count);
    }

}



