package again;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Programmers_신고결과받기_틀렸음 {

    public static void main(String[] args) {
        Programmers_신고결과받기_틀렸음 solution= new Programmers_신고결과받기_틀렸음();
        System.out.println(solution.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},2));
    }
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        String parser = ",";

        Map<String, String> maps = new HashMap<String,String>();
        Map<String, Integer> results = new HashMap<String,Integer>();

        for(int i = 0 ; i < report.length ; i++) {
            String reporter = getReporter(report[i]);
            String reported = getReported(report[i]);

            if(isReported(maps, reporter, reported)) continue;

            String result = maps.getOrDefault(reported,"");
            result += (reporter+parser);
            System.out.println(reported+" : "+result);
            maps.put(reported,result);
        }

        for(int i = 0 ; i < id_list.length ; i++) {
            int reporterCount = getReporterCount(maps, id_list[i], parser);
            if(reporterCount >= k) {
                String[] reporterArr = getReporterArr(maps, id_list[i], parser);
                Arrays.stream(reporterArr)
                        .forEach(reporter -> increaseMailNotificationCount(results, reporter));
            }
        }

        for(int i = 0 ; i < id_list.length ; i++) {
            answer[i] = results.getOrDefault(id_list[i],0);
        }
        return answer;
    }

    public int getReporterCount(Map<String, String> maps, String id, String parser) {
        String result = maps.getOrDefault(id,"");
        return result.split(parser).length;
    }

    public String[] getReporterArr(Map<String, String> maps, String reported, String parser) {
        return maps.getOrDefault(reported,"").split(parser);
    }

    public void increaseMailNotificationCount(Map<String, Integer> results, String id) {
        int result = results.getOrDefault(id,0);
        results.put(id,++result);
    }

    public boolean isReported(Map<String, String> maps, String reporter, String reported) {
        if(maps.getOrDefault(reported,"").contains(reporter)) return true;
        return false;
    }

    public String getReporter(String ids) {
        return ids.split(" ")[0];
    }

    public String getReported(String ids) {
        return ids.split(" ")[1];
    }
}