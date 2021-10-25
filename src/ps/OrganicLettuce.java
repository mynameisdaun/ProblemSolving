package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class OrganicLettuce {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int NumberOfWarm;
    static int NumberOfRow;
    static int NumberOfCol;
    static int NumberOfLettuce;
    static int[][] farm;

    public static void main(String[] args) throws IOException {
        OrganicLettuce OrganicLettuce = new OrganicLettuce();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int NumberOfTest = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < NumberOfTest ; i ++) {
            String[] farmInfo = br.readLine().split(" ");
            NumberOfWarm = 0;
            NumberOfCol  = Integer.parseInt(farmInfo[0]);
            NumberOfRow  = Integer.parseInt(farmInfo[1]);
            NumberOfLettuce = Integer.parseInt(farmInfo[2]);
            farm = new int[NumberOfRow][NumberOfCol];

            for(int j = 0 ; j < NumberOfLettuce ; j ++) {
                String[] lettuceLocation = br.readLine().split(" ");
                int col = Integer.parseInt(lettuceLocation[0]);
                int row = Integer.parseInt(lettuceLocation[1]);
                farm[row][col] = 1;
            }
            OrganicLettuce.solution(NumberOfCol, NumberOfRow, NumberOfLettuce);
        }
        br.close();
    }

    void solution(int NumberOfCol, int NumberOfRow, int NumberOfLettuce) {

        for(int y = 0; y < NumberOfRow; y++) {
            for(int x = 0; x < NumberOfCol; x++) {

                DFS(0, x, y);

            }
        }
        System.out.println(NumberOfWarm);
    }

    void DFS(int L, int x, int y) {

        if(farm[y][x]!=1) return;

        if(L==0&&farm[y][x]==1) {
            NumberOfWarm++;

        }

        farm[y][x]=0;
        for(int i = 0 ; i < 4 ; i ++) {
            int xpos = x+dx[i];
            int ypos = y+dy[i];
            if(xpos>=0&&xpos<NumberOfCol&&ypos>=0&&ypos<NumberOfRow&&farm[ypos][xpos]==1){
                DFS(L+1, xpos, ypos);
            }
        }
    }
}
