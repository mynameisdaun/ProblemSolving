package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
         String[] genres = {"classic", "pop", "classic", "classic", "pop"};
         int[] plays = {500, 600, 150, 800, 2500};

        String answer="";
        Map<String, Map<Integer, Integer>> repository = new HashMap<String, Map<Integer, Integer>>();
        Map<String, Integer> 장르별재생수 = new HashMap<String, Integer>();
        for(int i = 0 ; i < genres.length ; i ++) {
            Map<Integer, Integer> map = repository.getOrDefault(genres[i], new HashMap<Integer, Integer>());
            map.put(i,plays[i]);
            repository.put(genres[i], map);
            int count = 장르별재생수.getOrDefault(genres[i],0);
            장르별재생수.put(genres[i], count + plays[i]);
        }

        Map<String, Integer> sorted = 장르별재생수.entrySet()
                .stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for(String key : sorted.keySet()) {
            Map<Integer, Integer> map = repository.get(key);
            Map<Integer, Integer> sortedMap = map.entrySet()
                    .stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));

            int index = 0;
            for(Integer id : sortedMap.keySet()) {
                if(index>=2) continue;
                index++;
                answer+=(id+" ");
            }
        }

        System.out.println(answer);

        for(Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " : "+ entry.getValue());
        }




    }


}
