package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 씨름선수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int max = Integer.MIN_VALUE;
        List<Person> list = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(new Person(input[0], input[1]));
        }
        Collections.sort(list);

        for(int i = 0 ; i < list.size(); i++) {
            Person curr = list.get(i);
            if(curr.weight > max) {
                max = curr.weight;
                answer++;
            }
        }
        System.out.println(answer);
    }

    static class Person implements Comparable<Person> {
        private int height;
        private int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o) {
            if (this.height == o.height)
                return o.weight - this.weight;
            return o.height - this.height;
        }
    }
}
