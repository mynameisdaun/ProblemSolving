package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon_5014_스타트링크 {

    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        F = Integer.parseInt(str[0]);
        S = Integer.parseInt(str[1]);
        G = Integer.parseInt(str[2]);
        U = Integer.parseInt(str[3]);
        D = Integer.parseInt(str[4]);

        visited = new boolean[F+1];
        BFS();
        if(answer == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer);
        }
    }

    public static void BFS() {
        Queue<Stair> queue = new LinkedList<Stair>();

        queue.offer(new Stair(S,0));

        while(!queue.isEmpty()) {
            Stair crnt = queue.poll();
            int height = crnt.height;
            int count = crnt.count;
            //System.out.println("현재 높이는: "+height);
            //System.out.println("현재 카운트는: "+count);
            if(height==G) {
                answer = Math.min(answer, count);
                continue;
            }
            if(height>0&&height<=F&&!visited[height]) {
                visited[height] = true;
                queue.offer(new Stair(height+U,count+1));
                queue.offer(new Stair(height-D,count+1));
            }
        }
    }

    static class Stair {
        int height;
        int count;

        public Stair(int height, int count) {
            this.height = height;
            this.count = count;
        }

    }
}



