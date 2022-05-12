package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = br.readLine().toCharArray();
        List<Character> arr = new ArrayList<>();
        int sum = 0;

        for(int i = 0 ; i < c.length ; i++) {
            if(Character.isAlphabetic(c[i])) {
                arr.add(c[i]);
            }else {
                sum += Character.getNumericValue(c[i]);
            }
        }

        System.out.print(
                arr.stream().sorted().map(String::valueOf).collect(Collectors.joining())
        );
        System.out.println(sum);

    }
}
