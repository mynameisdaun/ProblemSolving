package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_17143_낚시왕 {

    static int row, col, m, location, answer = 0;

    static List<Shark> sharks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        row = Integer.parseInt(input[0]);
        col = Integer.parseInt(input[1]);
        m = Integer.parseInt(input[2]);
        for (int i = 0; i < m; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sharks.add(new Shark(s[0], s[1], s[2], s[3], s[4]));
        }

        location = 1;
        while (location <= col) {
            Shark closest = null;
            int index = -1;
            for (int i = 0; i < sharks.size(); i++) {
                Shark s = sharks.get(i);
                if (s.y == location) {
                    if (closest == null || closest.x > s.x) {
                        index = i;
                        closest = s;
                    }
                }
            }
            if (index > -1) {
                answer += sharks.remove(index).size;
            }
            sharks.stream().forEach(Shark::move);
            eat();
            location++;
        }
        System.out.println(answer);
    }

    static void eat() {
        int[][] board = new int[row + 1][col + 1];
        for (int i = 0; i < sharks.size(); i++) {
            int x = sharks.get(i).x;
            int y = sharks.get(i).y;
            board[x][y] = Math.max(board[x][y], sharks.get(i).size);
        }
        sharks = sharks.stream().filter(s -> s.size == board[s.x][s.y]).collect(Collectors.toList());
    }

    static class Shark {
        //위1 아래 2 오른 3 왼쪽 4
        private static int[] dx = {0, -1, 1, 0, 0};
        private static int[] dy = {0, 0, 0, 1, -1};
        private int x;
        private int y;
        private int speed;
        private int d;
        private int size;

        public Shark(int x, int y, int speed, int d, int size) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.d = d;
            this.size = size;
        }

        public void move() {
            for (int i = 0; i < speed; i++) {
                if ((d == 1 && x == 1) || (d == 3 && y == col)) {
                    d++;
                }
                if ((d == 2 && x == row) || (d == 4 && y == 1)) {
                    d--;
                }
                x += dx[d];
                y += dy[d];
            }
        }
    }
}
