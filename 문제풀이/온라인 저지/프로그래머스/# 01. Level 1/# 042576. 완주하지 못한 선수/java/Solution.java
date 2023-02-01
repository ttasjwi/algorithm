import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String solution(String[] participants, String[] completions) {
        Map<String, Integer> counter = new HashMap<>();
        for (String p : participants) counter.put(p, counter.getOrDefault(p, 0) + 1);
        for (String c : completions) counter.put(c, counter.get(c) - 1);

        for (String key : counter.keySet()) {
            if (counter.get(key) != 0) {
                return key;
            }
        }
        return "";
    }

}
