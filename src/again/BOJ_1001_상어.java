package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1001_상어 {
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Fish[][] board = new Fish[4][4];
        for (int i = 0; i < 4; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < 4; j++) {
                Fish fish = new Fish(input[j * 2], input[j * 2 + 1], false);
                board[i][j] = fish;
            }
        }
        //상어 수족관 입장
        Shark shark = new Shark(0, 0, board[0][0].index, board[0][0].direction);
        board[0][0].setEaten(true);
        DFS(board, shark);
        System.out.println(answer);
    }

    public static void DFS(Fish[][] board, Shark shark) {
        System.out.println("====================");
        System.out.println("현재 수족관의 상태입니다. 상어의 value는: "+shark.getValue());
        print(board, shark);
        answer = Math.max(shark.getValue(), answer);
        System.out.println("물고기가 움직이겠습니다. 물고기가 움직인 이후의 상태는?");
        moveFish(board, shark);
        print(board, shark);
        int nx = shark.getX() + dx[shark.direction];
        int ny = shark.getY() + dy[shark.direction];
        //상어가 움직일 공간이 있다면
        while (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && !board[nx][ny].isEaten()) {
            //상어 움직이고
            Fish[][] copy = arrayDeepCopy_2(board);
            copy[nx][ny].setEaten(true);
            System.out.println("상어가 움직이겠습니다!!");
            System.out.println("상어는 "+shark.getDirection()+" 방향으로 가고싶어 합니다.");
            DFS(copy,
                    new Shark(nx, ny, shark.value + board[nx][ny].getIndex(), board[nx][ny].getDirection()));
            System.out.println("더이상 상어가 갈 수 없군요 ㅠ");
            //상어 다시 전진
            System.out.println("nx: "+nx+" ny: "+ny);
            nx = nx + dx[shark.direction];
            ny = ny + dy[shark.direction];
        }
    }

    public static void moveFish(Fish[][] board, Shark shark) {
        int index = 1;
        boolean process = false;
        while (index <= 16) {
            process=false;
            for (int i = 0; i < 4; i++) {
                if(process) break;
                for (int j = 0; j < 4; j++) {
                    if(process) break;
                    if (board[i][j].getIndex() == index) {
                        Fish fish = board[i][j];
                        if (!fish.isEaten()) {
                            System.out.println("##### "+index+" 번 물고기의 움직임을 봅니다. 움직이기전, "+" #####");
                            print(board, shark);
                            int d = fish.getDirection();
                            int cnt = 0;
                            while (cnt < 8) {
                                int nd = (d + cnt > 8 ? d + cnt - 8 : d + cnt);
                                int nx = i + dx[nd];
                                int ny = j + dy[nd];
                                if(nx>=0&&nx<4&&ny>=0&&ny<4&&!(shark.getX()==nx&&shark.getY()==ny)) {
                                    /* swap */
                                    Fish tmp = new Fish(fish.getIndex(), nd, fish.eaten);
                                    board[i][j] = new Fish(board[nx][ny].getIndex(), board[nx][ny].getDirection(), board[nx][ny].eaten);
                                    board[nx][ny] = new Fish(tmp.getIndex(), tmp.getDirection(), tmp.eaten);
                                    System.out.println("##### "+index+" 번 물고기 움직이고 난 후 "+" #####");
                                    print(board, shark);
                                    break;
                                }
                                cnt++;
                            }
                        }
                        process=true;
                    }
                }
            }
            index++;
        }
    }

    static Fish[][] arrayDeepCopy_2(Fish[][] board) {
        Fish[][] copy = new Fish[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }

    static void print(Fish[][] board, Shark shark) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == shark.getX() && j == shark.getY()) {
                    System.out.print("🍓S, "+shark.getDirection()+"🍓 ");
                } else if (board[i][j].isEaten()) {
                    System.out.print("(X, ) ");
                } else {
                    System.out.print("("+board[i][j].getIndex()+", "+board[i][j].getDirection()+") ");
                }
            }
            System.out.println();
        }
    }

    static class Shark {
        private int x;
        private int y;
        private int value;
        private int direction;

        public Shark(int x, int y, int value, int direction) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.direction = direction;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getValue() {
            return value;
        }

        public void addValue(int value) {
            this.value += value;
        }

        public void subValue(int value) {
            this.value -= value;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }
    }

    static class Fish {
        private int index;
        private int direction;
        private boolean eaten;

        public Fish(int index, int direction, boolean eaten) {
            this.index = index;
            this.direction = direction;
            this.eaten = eaten;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }

        public boolean isEaten() {
            return eaten;
        }

        public void setEaten(boolean eaten) {
            this.eaten = eaten;
        }
    }
}

