package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BaekJoon_1253_영역구하기_DFS {

    static int ROW;
    static int COL;
    static int K;
    static int[][] BOARD;
    static boolean[][] visited;
    static int NumberOfWidth = 0;
    static Map<Integer, Integer> widthMap = new HashMap<Integer, Integer>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int count = 0 ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        ROW = Integer.parseInt(str[0]);
        COL = Integer.parseInt(str[1]);
        K = Integer.parseInt(str[2]);
        BOARD = new int[ROW][COL];
        visited = new boolean[ROW][COL];

        for(int i = 0 ; i < K ; i ++) {
            String[] coordinates = br.readLine().split(" ");
            fillBoard(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]),
                      Integer.parseInt(coordinates[2]), Integer.parseInt(coordinates[3]));
        }

        //print



        for(int i = 0 ; i < ROW; i ++) {
            for(int j = 0 ; j < COL ; j ++) {
                if(BOARD[i][j]==0){
                    BOARD[i][j]=1;
                    BFS(i,j ,++NumberOfWidth);
                }
            }
        }
        System.out.println(NumberOfWidth);
        widthMap.values().stream().sorted().forEach(width -> System.out.print(width+" "));

    }

    static void fillBoard(int leftX, int leftY, int rightX, int rightY) {

        for(int i = ROW-rightY ; i < ROW-leftY ; i ++) {
            for(int j = leftX ; j < rightX ; j ++) {
                BOARD[i][j] = 1;
                visited[i][j]=true;
            }
        }

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
                int ny = y + dy[i];;;
                if(nx>=0&&nx<ROW&&ny>=0&&ny<COL&&BOARD[nx][ny]==0) {
                    BOARD[nx][ny] = 1;
                    queue.add(new Integer[] {nx,ny});
                };;;
            }
        }

        widthMap.put(NumberOfWidth,count);;
    }

    static class Word implements Comparable<Word>{
        @Override
        public int compareTo(Word o) {
            return 0;
        }
    }

}



