package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class BaekJoon_2606_바이러스 {

    static int NumberOfComputer;
    static int NumberOfConnection;
    static boolean[] visited;
    static int[][] connection;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        NumberOfComputer = Integer.parseInt(br.readLine());
        NumberOfConnection = Integer.parseInt(br.readLine());

        visited    = new boolean[NumberOfComputer+1];
        connection = new int[NumberOfComputer+1][NumberOfComputer+1];

        for(int i = 1 ; i <= NumberOfConnection ; i ++) {
            String[] arr = br.readLine().split(" ");
            int node1 = Integer.parseInt(arr[0]);
            int node2 = Integer.parseInt(arr[1]);
            connection[node1][node2] = 1;
            connection[node2][node1] = 1;
        }

        BFS(1);
        for(boolean x : visited) {
            if(x) answer++;
        }
        System.out.println(answer-1);

    }

    static void BFS(int startNode) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[startNode] = true;
        queue.offer(startNode);

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int i = 1 ; i <= NumberOfComputer ; i ++) {
                if(!visited[i]&&connection[node][i]==1) {
                    visited[i]=true;
                    queue.offer(i);
                }
            }
        }
    }



}