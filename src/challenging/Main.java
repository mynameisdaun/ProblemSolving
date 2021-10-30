package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static BabyShark babyShark;
    static List<Fish> fishList = new LinkedList<Fish>();
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        //init
        for(int i = 0 ; i < n ; i ++) {
            String[] str = br.readLine().split(" ");
            for(int j = 0 ; j < n ; j ++) {
                map[i][j] = Integer.parseInt(str[j]);

                if(map[i][j]!=9&&map[i][j]!=0) {
                    fishList.add(new Fish(i, j, map[i][j]));
                }

                if(map[i][j]==9) {
                    babyShark = new BabyShark(i, j, 2, 0);
                }

            }
        }
        // init end

        Collections.sort(fishList, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                if(o1.size==o2.size) {
                    return o1.x==o2.x ? o1.y-o2.y : o1.x-o2.x;
                }else {
                    return o1.size-o2.size;
                }
            }
        });





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
        public Fish(int x, int y, int size) {
            this.x=x;
            this.y=y;
            this.size=size;
        }
    }
}
