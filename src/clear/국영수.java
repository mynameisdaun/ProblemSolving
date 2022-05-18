package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 국영수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Score[] input = new Score[N];
        for(int i = 0 ; i < input.length ; i++) {
            input[i] = new Score(br.readLine());
        }
        Arrays.stream(input)
                .sorted()
                .map(Score::getName)
                .forEach(System.out::println);
    }

    static class Score implements Comparable<Score>{
        private String name;
        private int k;
        private int e;
        private int m;

        public Score(String input) {
            String[] arr = input.split(" ");
            this.name = arr[0];
            this.k = Integer.parseInt(arr[1]);
            this.e = Integer.parseInt(arr[2]);
            this.m = Integer.parseInt(arr[3]);
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Score o) {
            if(this.k!=o.k) {
                return o.k-this.k;
            } else if(this.e!=o.e) {
                return this.e-o.e;
            } else if(this.m != o.m) {
                return o.m-this.m;
            } else {
                return this.name.compareTo(o.name);
            }
        }
    }
}
