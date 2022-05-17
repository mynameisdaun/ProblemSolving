package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 감시피하기 {
    static class Node {
        private int x;;
        private int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] board = new String[N+1][N+1];
        List<Node> teachers = new ArrayList<Node>();

        for(int i = 1 ; i <= N ; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 1 ; j <= N ; j++) {
                board[i][j] = input[j-1];
                if("T".equals(board[i][j])) {
                    teachers.add(new Node(i,j));
                }
            }
        }

        for(int i = 0 ; i < N * N ; i++) {
            int a = (i / N) + 1;
            int b = (i % N) + 1;
            if(!"X".equals(board[a][b])) continue;
            board[a][b] = "O";
            for(int j = i+1 ; j < N * N ; j++) {
                int c = (j / N) + 1;
                int d = (j % N) + 1;
                if(!"X".equals(board[c][d])) continue;
                board[c][d] = "O";
                for(int k = j+1 ; k < N * N ; k++) {
                    int e = (k / N) + 1;
                    int f = (k % N) + 1;
                    if(!"X".equals(board[e][f])) continue;
                    board[e][f]="O";
                    //print(board);
                    if(check(board, teachers, N)) {
                        System.out.println("YES");
                        return;
                    }
                    board[e][f]="X";
                }
                board[c][d] = "X";
            }
            board[a][b] = "X";
        }
        System.out.println("NO");
    }
    public static void print(String[][] board) {

    }

    public static boolean check(String[][] board, List<Node> teachers, int N) {
        for(int t = 0 ; t < teachers.size(); t++) {
            Node now = teachers.get(t);
            int x = now.getX();
            int y = now.getY();
            //상
            for(int i = x ; i >=1 ; i--) {
                if("O".equals(board[i][y])) {
                    break;
                } else if("S".equals(board[i][y])) {
                    return false;
                }
            }
            //하
            for(int i = x ; i <= N ; i++) {
                if("O".equals(board[i][y])) {
                    break;
                } else if("S".equals(board[i][y])) {
                    return false;
                }
            }
            //좌
            for(int i = y ; i >=1 ; i--) {
                if("O".equals(board[x][i])) {
                    break;
                } else if("S".equals(board[x][i])) {
                    return false;
                }
            }
            //우
            for(int i = y ; i <= N ; i++) {
                if ("O".equals(board[x][i])) {
                    break;
                } else if ("S".equals(board[x][i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
