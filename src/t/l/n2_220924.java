package t.l;

import java.io.IOException;
import java.util.regex.Pattern;

public class n2_220924 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        int k = 2;
        String[] dic = {"slang", "badword"};
        String chat = "badword ab.cd bad.ord .word sl.. bad.word";


        String solution1 = solution.solution(k, dic, chat);
        System.out.println(solution1);
    }

    //long으로 해야한다.
    static class Solution {
        public String solution(int k, String[] dic, String chat) {
            StringBuilder answer = new StringBuilder();
            String[] words = chat.split(" ");
            String cntStr = "";
            if (k == 1) {
                cntStr = ".{1}";
            } else {
                cntStr = ".{1," + k + "}";
            }


            for (int i = 0; i < words.length; i++) {
                String now = words[i];

                String regex = now.replace(".", cntStr);


                boolean find = false;
                for(String bad: dic) {
                    if(Pattern.matches(regex, bad)) {
                        for (int j = 0; j < now.length(); j++) {
                            answer.append("#");
                        }
                        find=true;
                        break;
                    }
                }
                if(!find) {
                    answer.append(now);
                }
                answer.append(" ");
            }
            return answer.toString().substring(0, answer.length()-1);
        }
    }
}

