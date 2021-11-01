package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BaekJoon_1260_DFS와BFS {

    static int NumberOfNode;
    static int NumberOfConnection;
    static int startNode;
    static int[][] map;
    static boolean[] visited;

    static List<Integer> answer_DFS = new LinkedList<Integer>();
    static List<Integer> answer_BFS = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        NumberOfNode = Integer.parseInt(arr[0]);
        NumberOfConnection = Integer.parseInt(arr[1]);
        startNode = Integer.parseInt(arr[2]);
        map = new int[NumberOfNode+1][NumberOfNode+1];

        for(int i = 0 ; i < NumberOfConnection ; i ++) {
            String[] conn = br.readLine().split(" ");
            map[Integer.parseInt(conn[0])][Integer.parseInt(conn[1])] = 1;
            map[Integer.parseInt(conn[1])][Integer.parseInt(conn[0])] = 1;
        }

        //DFS
        visited = new boolean[NumberOfNode+1];
        visited[startNode] = true;
        DFS(startNode);
        //BFS
        visited = new boolean[NumberOfNode+1];
        visited[startNode] = true;
        BFS(startNode);


        //System.out.println(answer_DFS);
        StringBuilder sb = new StringBuilder();
        for(Integer answer : answer_DFS) {
            sb.append(answer+" ");
        }
        System.out.println(sb.substring(0,sb.length()-1));

        sb = new StringBuilder();
        for(Integer answer : answer_BFS) {
            sb.append(answer+" ");
        }
        System.out.print(sb.substring(0,sb.length()-1));
    }

    static void DFS(int node) {
        //System.out.println("node: "+node);
        if(!answer_DFS.contains(node)) {
            answer_DFS.add(node);
        }

        for(int i = 1 ; i <= NumberOfNode ; i ++) {
            if(!visited[i]&&(map[node][i]==1||map[i][node]==1)) {
                visited[i]=true;
                DFS(i);
            }
        }
    }

    static void BFS(int strtNode) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(strtNode);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            //System.out.println("node: "+node);
            if(!answer_BFS.contains(node)) {
                answer_BFS.add(node);
            }
            for(int i = 1 ; i <= NumberOfNode ; i ++) {
                if(!visited[i]&&(map[node][i]==1||map[i][node]==1)) {
                    visited[i]=true;
                    queue.offer(i);
                }
            }
        }
    }

}