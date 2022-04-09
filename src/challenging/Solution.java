package challenging;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String tstring = "this is {template} {template} is {state}";
        String[][] variables = new String[][]{{"template","{state}"},{"state","{template}"}};
        System.out.println(solution(tstring, variables));
    }

        public static String solution(String tstring, String[][] variables) {
            Map<String, String> map = new HashMap<>();
            for(String[] variable : variables) {
                map.put(variable[0], variable[1]);
            }

            for(String[] variable : variables) {
                String A = variable[0];
                String B = variable[1];

                String C = getTemplate(A,B,map);
                System.out.println("key: "+A+" values: "+B);
                //map.put(A,C);
            }
            for(String key : map.keySet()) {
                tstring = tstring.replaceAll("\\{"+key+"\\}",getTemplate(key, map.get(key),map));
            }

            return tstring;
        }

        public static String getTemplate(String A, String B, Map<String, String> map) {
            //다음것
            if(!B.startsWith("{")) {
                return B;
            }
            String C = map.get(B.substring(1,B.length()-1));
            //없다면
            if( C == null) {
                return B;
            }
            if(!C.startsWith("{")) {
                return C;
            }
            if(C.startsWith("{")) {
                System.out.print("A "+A+" ");
                System.out.print("B "+B+" ");
                System.out.println("C"+C);
                if(C.substring(1, C.length()-1).equals(A)) {
                    System.out.println("hello!");
                    return "{"+A+"}";
                }
                return getTemplate(A,C,map);
            }
            return "";
        }


}
