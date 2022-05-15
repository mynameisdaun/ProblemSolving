package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String direction = "R";
    static int[] head = {1,1};
    static Queue<int[]> queue = new LinkedList<>();
    static final int apple = 4;
    static final int snake = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N+1][N+1];
        int K = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < K ; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            board[input[0]][input[1]]=apple;
        }
        int L = Integer.parseInt(br.readLine());
        Map<Integer, String> map = new HashMap<>();
        for(int i = 0; i < L ; i++) {
            String[] input = br.readLine().split(" ");
            map.put(Integer.parseInt(input[0]), input[1]);
        }

        queue.offer(new int[]{1, 1});
        while(true) {
            //움직인다(사과있는지확인한다)
            count++;
            if(!move(board, N)) {
                break;
            }
            //방향바꾼다
            if(map.containsKey(count)) {
                changeDirection(map.get(count));
            }
        }
        System.out.println(count);
    }
    static void changeDirection(String d) {
        //오른쪽 90
        if("D".equals(d)) {
            if("R".equals(direction)) {
                direction="D";
            }
            else if("L".equals(direction)) {
                direction="U";
            }
            else if("U".equals(direction)) {
                direction="R";
            }
            else if("D".equals(direction)) {
                direction="L";
            }
        }
        //왼쪽 90
        if("L".equals(d)) {
            if("R".equals(direction)) {
                direction="U";
            }
            else if("L".equals(direction)) {
                direction="D";
            }
            else if("U".equals(direction)) {
                direction="L";
            }
            else if("D".equals(direction)) {
                direction="R";
            }
        }
    }

    static void print(int[][] board, int N, int count) {
        System.out.println("============ START =========");
        System.out.println("count: "+count);
        for(int i = 1; i <= N ; i++) {
            for(int j = 1; j <= N ; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("============ E N D =========");
    }

    static boolean move (int[][] board, int N) {
        if("R".equals(direction)) {
            int nx = head[0];
            int ny = head[1]+1;
            if(nx>=1&&nx<=N&&ny>=1&&ny<=N&&board[nx][ny]!=snake) {
                head[1]=ny;
                queue.offer(new int[]{nx, ny});
                if(board[nx][ny]!=apple) {
                    int[] tail = queue.poll();
                    board[tail[0]][tail[1]]=0;
                }
                board[head[0]][head[1]] = snake;
                return true;
            }
        }
        if("L".equals(direction)) {
            int nx = head[0];
            int ny = head[1]-1;
            if(nx>=1&&nx<=N&&ny>=1&&ny<=N&&board[nx][ny]!=snake) {
                head[1]=ny;
                queue.offer(new int[]{nx, ny});
                if(board[nx][ny]!=apple) {
                    int[] tail = queue.poll();
                    board[tail[0]][tail[1]]=0;
                }
                board[head[0]][head[1]] = snake;
                return true;
            }
        }
        if("U".equals(direction)) {
            int nx = head[0]-1;
            int ny = head[1];
            if(nx>=1&&nx<=N&&ny>=1&&ny<=N&&board[nx][ny]!=snake) {
                head[0]=nx;
                queue.offer(new int[]{nx, ny});
                if(board[nx][ny]!=apple) {
                    int[] tail = queue.poll();
                    board[tail[0]][tail[1]]=0;
                }
                board[head[0]][head[1]] = snake;
                return true;
            }
        }
        if("D".equals(direction)) {
            int nx = head[0]+1;
            int ny = head[1];
            if(nx>=1&&nx<=N&&ny>=1&&ny<=N&&board[nx][ny]!=snake) {
                head[0]=nx;
                queue.offer(new int[]{nx, ny});
                if(board[nx][ny]!=apple) {
                    int[] tail = queue.poll();
                    board[tail[0]][tail[1]]=0;
                }
                board[head[0]][head[1]] = snake;
                return true;
            }
        }
        return false;
    }
}
