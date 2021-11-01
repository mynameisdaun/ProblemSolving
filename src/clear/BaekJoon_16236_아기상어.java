package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_16236_아기상어 {

    static int[][] map;
    static BabyShark babyShark;
    static List<Fish> fishList = new LinkedList<Fish>();
    static boolean[][] visited;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int answer = 0;
    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0 ; i < n ; i ++) {
            String[] str = br.readLine().split(" ");
            for(int j = 0 ; j < n ; j ++) {
                map[i][j] = Integer.parseInt(str[j]);

                if(map[i][j]!=9&&map[i][j]!=0) {
                    fishList.add(new Fish(i, j, map[i][j], 0));
                }
                else if(map[i][j]==9) {
                    babyShark = new BabyShark(i, j, 2, 0);
                    map[i][j]=0;
                }
            }
        }
        fishList.forEach( fish -> fish.distance=getDistance(fish.x,fish.y));
        Collections.sort(fishList, new fishComparator());

        while(!fishList.isEmpty()) {
            Fish crntFish = fishList.get(0);
            fishList.remove(0);

            if(crntFish.size >= babyShark.size || crntFish.distance >= n*n) {
                break;
            } else {

                answer += crntFish.distance;

                babyShark.x = crntFish.x;
                babyShark.y = crntFish.y;

                babyShark.eat++;
                if(babyShark.size == babyShark.eat) {
                    babyShark.size++;
                    babyShark.eat=0;
                }
                fishList.forEach( fish -> fish.distance=getDistance(fish.x,fish.y));
                Collections.sort(fishList, new fishComparator());
            }
        }
        System.out.println(answer);
    }

    static class BabyShark {
        int x;
        int y;
        int size;
        int eat;
        public BabyShark(int x, int y, int size, int eat) {
            this.x=x;
            this.y=y;
            this.size=size;
            this.eat=eat;
        }
    }

    static class Fish {
        int x;
        int y;
        int size;
        int distance;
        public Fish(int x, int y, int size, int distance) {
            this.x=x;
            this.y=y;
            this.size=size;
            this.distance=distance;
        }
    }

    static class fishComparator implements Comparator<Fish> {

        @Override
        public int compare(Fish o1, Fish o2) {
            int eatAble1   = babyShark.size - o1.size  > 0 ? 1 : -1;
            int eatAble2   = babyShark.size - o2.size  > 0 ? 1 : -1;
            int distance1 = getDistance(o1.x, o1.y);
            int distance2 = getDistance(o2.x, o2.y);

            if(eatAble1 == eatAble2) {
                if(distance1==distance2) {
                    return o1.x == o2.x ? o1.y-o2.y : o1.x-o2.x;
                }else {
                    return distance1-distance2;
                }
            } else {
                return eatAble2-eatAble1;
            }
        }
    }

    static int getDistance(int fishX, int fishY) {
        int min = Integer.MAX_VALUE;
        visited = new boolean[n][n];
        Queue<Integer[]> queue = new LinkedList<Integer[]>();
        queue.offer(new Integer[] {babyShark.x, babyShark.y,0});
        while(!queue.isEmpty()) {
            Integer[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currS = curr[2];
            if(currS>=min) {
                continue;
            }
            if(currX==fishX&&currY==fishY) {
                min = Math.min(min, currS);
                continue;
            }
            else {
                for(int i = 0 ; i < 4 ; i ++) {
                    int nx = currX + dx[i];
                    int ny = currY + dy[i];
                    if(nx>=0&&nx<n&&ny>=0&&ny<n&&!visited[nx][ny]&&map[nx][ny]<= babyShark.size) {
                        visited[nx][ny]=true;
                        queue.offer(new Integer[] {nx, ny, currS+1});
                    }
                }
            }
        }
        return min;
    }
}