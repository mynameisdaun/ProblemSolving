package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, board[][], WHITE = 1,
            changes[][], dx[] = {-1, 0, 1, 0}, dy[] = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        changes = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                board[i][j] = str.charAt(j) - '0';
                changes[i][j] = Integer.MAX_VALUE;
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Room> queue = new LinkedList<>();
        queue.add(new Room(0, 0));
        changes[0][0] = 0;
        while (!queue.isEmpty()) {
            Room room = queue.poll();
            int x = room.x;
            int y = room.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && changes[nx][ny] > changes[x][y]) {
                    if (board[nx][ny] == WHITE) {
                        changes[nx][ny] = changes[x][y];
                    } else {
                        changes[nx][ny] = changes[x][y] + 1;
                    }
                    queue.add(new Room(nx, ny));
                }
            }
        }
        return changes[n - 1][n - 1];
    }


    static class Room {
        int x;
        int y;


        public Room(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] input(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
    }

}
