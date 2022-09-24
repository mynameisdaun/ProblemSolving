package t.l;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class n1_220924 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        int[][] queries = {{2,10},{7,1},{2,5},{2,9},{7,32}};
        long solution1 = solution.solution(queries);
        System.out.println(solution1);
    }
    //long으로 해야한다.
    static class Solution {
        public long solution(int[][] queries) {
            Map<Integer, long[]> map = new HashMap<>();
            long answer = 0;
            for (int i = 0; i < queries.length; i++) {
                int[] curr = queries[i];
                int index = queries[i][0];
                int count = queries[i][1];

                //총 갯수, 현재들어있는 개수
                long[] arr = map.getOrDefault(index, new long[]{0,0});

                if( count > arr[0]-arr[1]) {
                    //새로운 원소의 개수
                    System.out.println("index: "+index+" 현재 배열 크기: "+arr[0]+"현재들어있는 원소 "+arr[1]);
                    long newCount = arr[1] + count;
                    System.out.println("필요한 원소의 개수: "+newCount);
                    int pow = 0;
                    while(Math.pow(2,pow) < newCount) {
                        pow++;
                    }
                    System.out.println("다음 배열의 크기: "+Math.pow(2,pow));
                    answer += arr[1];
                    System.out.println("복사된 수: "+arr[1]);
                    arr[0] = (long) Math.pow(2,pow);
                    arr[1] = newCount;
                    map.put(index, arr);
                } else {
                    arr[1]+=count;
                }
            }
            return answer;
        }
    }
}

