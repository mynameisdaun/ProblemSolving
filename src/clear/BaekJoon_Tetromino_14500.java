package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_Tetromino_14500 {
    static int row;
    static int col;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        row = Integer.parseInt(str[0]);
        col = Integer.parseInt(str[1]);
        map = new int[row][col];
        visited = new boolean[row][col];

        for(int i = 0 ; i < row ; i ++) {
            String[] colArr = br.readLine().split(" ");
            for(int j = 0 ; j < col ; j++) {
                map[i][j] = Integer.parseInt(colArr[j]);
            }
        }

        for(int i = 0 ; i < row; i ++) {
            for(int j = 0 ; j < col ; j ++) {
                visited[i][j] = true;
                DFS(1, map[i][j], i, j);
                checkCross(map[i][j], i, j);
                visited[i][j] = false;
            }
        }
        System.out.println(answer);
    }

    static void DFS(int L, int S, int x, int y) {
        if(L==4) {
            answer = Math.max(S,answer);
        } else {

            for(int i = 0 ; i < 4; i ++ ) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0&&nx<row&&ny>=0&&ny<col&&!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    DFS(L+1, S+map[nx][ny],nx,ny);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    static void checkCross(int S, int x, int y) {
        int lx = x-1; int ly = y;
        int rx = x+1; int ry = y;
        int dx = x;   int dy = y-1;
        int ux = x;   int uy = y+1;

        // ㅏ shape
        if(ux>=0&&ux<row&&uy>=0&&uy<col&&rx>=0&&rx<row&&ry>=0&&ry<col&&dx>=0&&dx<row&&dy>=0&&dy<col) {
            int shape_ㅏ = S + map[ux][uy]+map[rx][ry]+map[dx][dy];
            answer = Math.max(shape_ㅏ,answer);
        }
        // ㅗ shape
        if(ux>=0&&ux<row&&uy>=0&&uy<col&&rx>=0&&rx<row&&ry>=0&&ry<col&&lx>=0&&lx<row&&ly>=0&&ly<col) {
            int shape_ㅗ= S + map[ux][uy]+map[rx][ry]+map[lx][ly];
            answer = Math.max(shape_ㅗ,answer);
        }
        // ㅜ shape
        if(dx>=0&&dx<row&&dy>=0&&dy<col&&rx>=0&&rx<row&&ry>=0&&ry<col&&lx>=0&&lx<row&&ly>=0&&ly<col) {
            int shape_ㅜ= S + map[dx][dy]+map[rx][ry]+map[lx][ly];
            answer = Math.max(shape_ㅜ,answer);
        }
        // ㅓ  shape
        if(dx>=0&&dx<row&&dy>=0&&dy<col&&ux>=0&&ux<row&&uy>=0&&uy<col&&lx>=0&&lx<row&&ly>=0&&ly<col) {
            int shape_ㅓ= S + map[dx][dy]+map[ux][uy]+map[lx][ly];
            answer = Math.max(shape_ㅓ,answer);
        }
    }


}
