package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int answer = Integer.MAX_VALUE;
    static int M = 100000;
    static boolean[] visited = new boolean[M+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        int subin = Integer.parseInt(arr[0]);
        int sister = Integer.parseInt(arr[1]);

        BFS(subin,sister);


    }

    static void BFS(int subin, int sister) {
        Queue<Location> queue = new LinkedList<Location>();

        visited[subin]=true;
        queue.offer(new Location(subin,0));

        while(!queue.isEmpty()) {
            Location loc = queue.poll();
            //System.out.println(loc.loc);

            if(sister == loc.loc) {
                System.out.println(loc.time);
                return;
            } else {

                int multipleTwo = loc.loc*2;
                int addOne = loc.loc+1;
                int minusOne = loc.loc-1;

                if(multipleTwo <= M&&!visited[multipleTwo]) {
                    visited[multipleTwo]=true;
                    queue.offer(new Location(multipleTwo, loc.time+1));
                }

                if(addOne <= M&&!visited[addOne]) {
                    visited[addOne]=true;
                    queue.offer(new Location(addOne, loc.time+1));
                }

                if(minusOne >= 0 && !visited[minusOne]) {
                    visited[minusOne]=true;
                    queue.offer(new Location(minusOne, loc.time+1));
                }

            }

        }



    }

    static class Location {
        int loc;
        int time;
        public Location(int loc, int time) {
            this.loc = loc;
            this.time= time;
        }
    }



}


