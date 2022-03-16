package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] board;
    static int N;
    static int M;
    static int answer = Integer.MAX_VALUE;
    static List<Point> 집주소리스트 = new ArrayList<Point>();
    static List<Point> 피자집주소리스트 = new ArrayList<Point>();
    static Point[] 피자집그룹;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];
        board = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i ++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 1 ; j <= N ; j ++) {
                board[i][j] = arr[j-1];
                if(board[i][j]==1) 집주소리스트.add(new Point(i, j, 0));
                if(board[i][j]==2) 피자집주소리스트.add(new Point(i, j, 0));
            }
        }
        피자집그룹 = new Point[M];

        최소피자배달거리구하기(0,0);
        System.out.println(answer);
    }

    static void 최소피자배달거리구하기(int L, int S) {
        if(L==M) {
            int[][] city = 선택된피자집그룹으로도시그리기();
            answer = Math.min(피자그룹별배달최소거리(city), answer);
        } else {
            for(int i = S; i < 피자집주소리스트.size() ; i ++) {
                피자집그룹[L] = 피자집주소리스트.get(i);
                최소피자배달거리구하기(L+1,i+1);
            }
        }
    }

    static int 피자그룹별배달최소거리(int[][] city) {
        return 집주소리스트.stream()
                .mapToInt(집 -> 가정과피자집의최소거리(집.x, 집.y, city))
                .sum();
    }

    static int 가정과피자집의최소거리(int x, int y, int[][] city) {
        boolean[][] 지나온경로 = new boolean[N+1][N+1];
        Queue<Point> queue = new LinkedList<Point>(Arrays.asList(new Point(x,y,0)));
        지나온경로[x][y]=true;
        while(!queue.isEmpty()) {
            Point tmp = queue.poll();
            if(city[tmp.x][tmp.y]==2) {
                return tmp.L;
            }
            for(int m = 0 ; m < dx.length ; m ++) {
                int nx = tmp.x + dx[m];
                int ny = tmp.y + dy[m];
                if(nx>=1&&nx<=N&&ny>=1&&ny<=N&&!지나온경로[nx][ny]) {
                    지나온경로[nx][ny]=true;
                    queue.offer(new Point(nx, ny, tmp.L+1));
                }
            }
        }
        return 0;
    }

    static int[][] 선택된피자집그룹으로도시그리기() {
        int[][] city = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i ++) {
            for(int j = 1 ; j <= N ; j ++) {
                if(board[i][j]==2) {
                    city[i][j] = 0;
                    continue;
                }
                city[i][j]=board[i][j];
            }
        }
        for(int i = 0 ; i < M ; i ++) {
            Point 피자집 = 피자집그룹[i];
            city[피자집.x][피자집.y] = 2;
        }
        return city;
    }

    static class Point {
        private int x;
        private int y;
        private int L;

        public Point(int x, int y, int L) {
            this.x=x;
            this.y=y;
            this.L=L;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            if (y != point.y) return false;
            return L == point.L;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + L;
            return result;
        }
    }
}
