package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BaekJoon_1620_나는야포켓몬마스터이다솜 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int numberOfPoketmon = Integer.parseInt(str[0]);
        int numberOfQuiz = Integer.parseInt(str[1]);

        Map<String, Integer> map_name_number = new HashMap<String, Integer>();
        Map<Integer, String> map_number_name = new HashMap<Integer, String>();

        for(int i = 1 ; i <= numberOfPoketmon ; i ++) {
            String nameOfPoketmon = br.readLine();
            map_name_number.put(nameOfPoketmon,i);
            map_number_name.put(i, nameOfPoketmon);
        }

        for(int i = 0 ; i < numberOfQuiz ; i ++) {
            String quiz = br.readLine();
            char firstCharacter = quiz.charAt(0);

            if(Character.isDigit(firstCharacter)) {
                System.out.println(map_number_name.get(Integer.parseInt(quiz)));
            } else {
                System.out.println(map_name_number.get(quiz));
            }

        }


    }


}


