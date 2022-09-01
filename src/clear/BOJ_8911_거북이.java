package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8911_거북이 {
    static int[] dx = {-1, +0, +1, 0};
    static int[] dy = {+0, -1, +0, +1};//북 서 남 동
    //오른쪽회전 시 (+3)%4 왼쪽 회전시 (+1)%4

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcase = Integer.parseInt(br.readLine());
        while (tcase-- > 0) {
            char[] command = br.readLine().toCharArray();
            Node turtle = new Node(0, 0, 0);
            int l = 0;
            int r = 0;
            int t = 0;
            int b = 0;
            for (int i = 0; i < command.length; i++) {
                if(command[i]=='F') {
                    turtle.x += dx[turtle.d];
                    turtle.y += dy[turtle.d];
                }
                if(command[i]=='B') {
                    turtle.x -= dx[turtle.d];
                    turtle.y -= dy[turtle.d];
                }
                if(command[i]=='L') {
                    turtle.d = (turtle.d+1) % 4;
                }
                if(command[i]=='R') {
                    turtle.d = (turtle.d+3) % 4;
                }

                l = Math.min(turtle.y, l);
                r = Math.max(turtle.y, r);
                t = Math.min(turtle.x, t);
                b = Math.max(turtle.x, b);
            }
            System.out.println(Math.abs(l - r) * Math.abs(t - b));
        }
    }

    static class Node {
        int x;
        int y;
        int d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
