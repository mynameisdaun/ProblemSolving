package challenging;

import sun.awt.image.ImageWatched;

import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] graph = new int[rows][columns];

        Deque deque = new LinkedList();
        Collections.sort(new ArrayList<>(), Collections.reverseOrder());



        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < columns ; j++) {
                graph[i][j] = ((i)*columns + j+1);
            }
        }

        for(int i = 0 ; i < queries.length ; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            answer[i] = rotate(graph, x1-1, y1-1, x2-1, y2-1);
        }
        return answer;
    }

    public int rotate(int[][] graph, int x1, int y1, int x2, int y2) {
        int start = graph[x1][y1];
        int min = start;
        //left
        for(int i = x1 ; i < x2 ; i++) {
            int next = graph[i+1][y1];
            graph[i][y1] = next;
            min = Math.min(min, next);
        }
        //down
        for(int i = y1 ; i < y2 ; i++) {
            int next = graph[x2][i+1];
            graph[x2][i] = next;
            min = Math.min(min, next);
        }
        //right
        for(int i = x2 ; i > x1 ; i--) {
            int next = graph[i-1][y2];
            graph[i][y2] = next;
            min = Math.min(min, next);
        }
        //up
        for(int i = y2 ; i > y1 ; i--) {
            int next = graph[x1][i-1];
            graph[x1][i] = next;
            min = Math.min(min, next);
        }
        graph[x1][y1+1]=start;
        return min;
    }
}
