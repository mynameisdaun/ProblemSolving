package challenging;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        map.put("정다운",100);
        map.put("이순신",77);
        map.put("홍길동",95);
        Map<String, Integer> sorted = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        //key, value, mergeFunction, map
        sorted.forEach((k,v)->System.out.println(k+"="+v));

    }

}

