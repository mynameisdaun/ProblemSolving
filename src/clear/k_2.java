package clear;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class k_2 {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
//        String[] commands = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice",
//                "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian",
//                "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"
//        };
//        String[] commands = {"UPDATE 1 1 a", "UPDATE 1 5 b", "MERGE 1 5 1 1", "PRINT 1 1", "UNMERGE 1 1", "PRINT 1 1", "PRINT 1 5"};
//        String[] commands = {"MERGE 1 1 1 2", "MERGE 1 2 1 3", "UPDATE 1 2 hi", "PRINT 1 1"};
        String[] commands = {"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 1 3 c", "UPDATE 2 1 d", "UPDATE 2 2 e", "UPDATE 2 3 f", "MERGE 1 3 1 1", "MERGE 1 2 1 3", "MERGE 2 3 2 1", "MERGE 2 2 2 3", "MERGE 2 1 1 1", "PRINT 1 1", "PRINT 2 3"};
//        String[] commands = {"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"};
        //String[] commands = {"UNMERGE 1 1"};
        String[] solution1 = solution.solution(commands);

        for (int i = 0; i < solution1.length; i++) {
            System.out.print(solution1[i] + " ");
        }
        System.out.println();
    }

    static class Solution {

        static int[][][] parents;
        static String[][] board;


        static void union(int[] a, int[] b, String value) {
            String parent = "";
            if (a[0] < b[0]) {
                parents[b[0]][b[1]] = a;
                board[a[0]][a[1]] = value;
                board[b[0]][b[1]] = value;
                parent = "a";
            } else if (a[0] > b[0]) {
                parents[a[0]][a[1]] = b;
                board[a[0]][a[1]] = value;
                board[b[0]][b[1]] = value;
                parent = "b";
            } else {
                if (a[1] < b[1]) {
                    parents[b[0]][b[1]] = a;
                    board[a[0]][a[1]] = value;
                    board[b[0]][b[1]] = value;
                    parent = "a";
                } else if (a[1] > b[1]) {
                    parents[a[0]][a[1]] = b;
                    board[a[0]][a[1]] = value;
                    board[b[0]][b[1]] = value;
                    parent = "b";
                }
            }

            for (int i = 1; i <= 50; i++) {
                for (int j = 1; j <= 50; j++) {
                    if ((parents[i][j][0] == a[0] && parents[i][j][1] == a[1]) || (parents[i][j][0] == b[0] && parents[i][j][1] == b[1])) {
                        board[i][j]=value;
                    }
                    if("a".equals(parent)&&parents[i][j][0] == b[0] && parents[i][j][1] == b[1]) {
                        parents[i][j] = a;
                    }
                    if("b".equals(parent)&&parents[i][j][0] == a[0] && parents[i][j][1] == a[1]) {
                        parents[i][j] = b;
                    }
                }
            }

        }

        static int[] find(int[] a) {
            int x = a[0];
            int y = a[1];
            if (parents[x][y][0] == x && parents[x][y][1] == y)
                return a;
            return parents[x][y] = find(parents[x][y]);
        }


        public static String[] solution(String[] commands) {
            List<String> answer = new ArrayList<>();

            board = new String[51][51];
            parents = new int[51][51][2];

            for (int i = 1; i <= 50; i++) {
                for (int j = 1; j <= 50; j++) {
                    board[i][j] = "";
                    parents[i][j] = new int[]{i, j};
                }
            }

            for (int i = 0; i < commands.length; i++) {
                String[] command = commands[i].split(" ");

                System.out.println(commands[i]);

                String c = command[0];

                if (c.equals("UPDATE") && command.length == 4) {
                    int[] a = find(new int[]{Integer.parseInt(command[1]), Integer.parseInt(command[2])});

                    for (int j = 1; j <= 50; j++) {
                        for (int k = 1; k <= 50; k++) {
                            if (parents[j][k][0] == a[0] && parents[j][k][1] == a[1]) {
                                board[j][k] = command[3];
                            }
                        }
                    }
                }
                if (c.equals("UPDATE") && command.length == 3) {
                    for (int j = 1; j <= 50; j++) {
                        for (int k = 1; k <= 50; k++) {
                            if (board[j][k].equals(command[1])) {
                                board[j][k] = command[2];
                            }
                        }
                    }
                }
                if (c.equals(("MERGE"))) {
                    int[] a = find(new int[]{Integer.parseInt(command[1]), Integer.parseInt(command[2])});
                    int[] b = find(new int[]{Integer.parseInt(command[3]), Integer.parseInt(command[4])});
                    String aValue = board[a[0]][a[1]];
                    String bValue = board[b[0]][b[1]];
                    String value = "";
                    if (!"".equals(aValue) && "".equals(bValue)) {
                        value = aValue;
                    }
                    if ("".equals(aValue) && !"".equals(bValue)) {
                        value = bValue;
                    }
                    if (!"".equals(aValue) && !"".equals(bValue)) {
                        value = aValue;
                    }
                    union(a, b, value);
                }
                if (c.equals(("UNMERGE"))) {
                    int[] a = find(new int[]{Integer.parseInt(command[1]), Integer.parseInt(command[2])});
                    String value = board[a[0]][a[1]];
                    for (int j = 1; j <= 50; j++) {
                        for (int k = 1; k <= 50; k++) {
                            if (parents[j][k][0] == a[0] && parents[j][k][1] == a[1]) {
                                parents[j][k] = new int[]{j, k};
                                board[j][k] = "";
                            }
                        }
                    }
                    board[Integer.parseInt(command[1])][Integer.parseInt(command[2])] = value;
                }
                if (c.equals(("PRINT"))) {
                    int[] a = find(new int[]{Integer.parseInt(command[1]), Integer.parseInt(command[2])});
                    answer.add(board[a[0]][a[1]].equals("") ? "EMPTY" : board[a[0]][a[1]]);
                }
                System.out.println("========================================");
                for (int j = 1; j <= 10; j++) {
                    for (int k = 1; k <= 10; k++) {
                        System.out.print((board[j][k].equals("") ? "." : board[j][k]) + " ");
                    }
                    System.out.println();
                }
            }
            return answer.stream().toArray(String[]::new);
        }
    }
}

