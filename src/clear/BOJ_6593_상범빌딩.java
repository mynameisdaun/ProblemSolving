package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_6593_상범빌딩 {
    static int[] dz = {1,-1,0,0,0,0};
    static int[] dx = {0,0,1,-1,0,0};
    static int[] dy = {0,0,0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String input = br.readLine();
            if(input.equals("0 0 0")) { break; }
            int[] arr = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int L = arr[0];
            int R = arr[1];
            int C = arr[2];
            String[][][] board = new String[L][R][C];
            Node start = null;
            Node end = null;
            for(int i = 0 ; i < L ; i++) {
                for(int j = 0 ; j < R ; j++) {
                    String[] in = br.readLine().split("");
                    for(int k = 0 ; k < C ; k++) {
                        if(in[k].equals("S")){
                            start = new Node(i,j,k,0);
                        }
                        if(in[k].equals("E")){
                            end = new Node(i,j,k,0);
                        }
                        board[i][j][k]=in[k];
                    }
                }
                br.readLine();
            }
            if(end==null||start==null) {
                System.out.println("Trapped!");
                continue;
            }
            //System.out.println("층: "+start.z+" x: "+start.x+", y: "+start.y+" d: "+start.d);
            Queue<Node> queue = new LinkedList<>();
            queue.offer(start);
            boolean find = false;
            while(!queue.isEmpty()) {
                Node curr = queue.poll();
                //System.out.println("층: "+curr.z+" x: "+curr.x+", y: "+curr.y+" d: "+curr.d);
                if(curr.z==end.z&&curr.y==end.y&&curr.x==end.x) {
                    find = true;
                    System.out.println("Escaped in "+curr.d+" minute(s).");
                    break;
                }
                for(int i = 0 ; i < 6 ; i++) {
                    int nz = curr.z + dz[i];
                    int nx = curr.x + dx[i];
                    int ny = curr.y + dy[i];
                    if(nz>=0&&nz<L&&nx>=0&&nx<R&&ny>=0&&ny<C&&!board[nz][nx][ny].equals("#")) {
                        board[nz][nx][ny]="#";
                        queue.offer(new Node(nz, nx, ny, curr.d + 1));
                    }
                }
            }
            if(!find) {
                System.out.println("Trapped!");
            }
        }
    }

    static class Node {
        int z;
        int x;
        int y;
        int d;

        public Node(int z, int x, int y, int d) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
