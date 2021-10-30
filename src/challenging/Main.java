//package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int unripped = 0;
    static int ripped = 0 ;
    static int dayCount = 0;
    static int row;
    static int col;
    static int h;
    static int[][][] farm;
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        row = Integer.parseInt(str[1]);
        col = Integer.parseInt(str[0]);
        h   = Integer.parseInt(str[2]);
        farm = new int[row][col][h];

        Queue<Tomato> queue = new LinkedList<Tomato>();

        for(int m = 0 ; m < h ; m++) {
            for(int i = 0 ; i < row; i ++) {
                String[] columnArr = br.readLine().split(" ");
                for (int j = 0; j < col; j++) {
                    farm[i][j][m] = Integer.parseInt(columnArr[j]);
                    if (Integer.parseInt(columnArr[j]) == 0) unripped++;
                    if (Integer.parseInt(columnArr[j]) == 1) queue.offer((new Tomato(i,j,m,0)));
                }
            }
        }

        if(unripped == 0 ){
            System.out.println("0");
            return;
        }

        while(!queue.isEmpty()) {

            Tomato tomato = queue.poll();
            dayCount = Math.max(dayCount,tomato.day);

            for(int i = 0 ; i < 6 ; i ++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                int nz = tomato.z + dz[i];

                if(nx>=0&&nx<row&&ny>=0&&ny<col&&nz>=0&&nz<h&&farm[nx][ny][nz]==0) {
                    ripped++;
                    farm[nx][ny][nz]=1;
                    queue.offer(new Tomato(nx,ny, nz, tomato.day+1));
                }
            }
        }
        System.out.println(ripped==unripped ? dayCount : -1);
    }

    static class Tomato {
        int x;
        int y;
        int z;
        int day;
        public Tomato(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

}
