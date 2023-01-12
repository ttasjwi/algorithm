import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public int[] solution(int[] emergency) {
        Map<Integer, Integer> rankMap = getRankMap(emergency);
        return getResult(emergency, rankMap);
    }

    private static Map<Integer, Integer> getRankMap(int[] emergency) {
        Map<Integer, Integer> ranks = new HashMap<>();

        int[] sortedEmergency = Arrays.copyOfRange(emergency, 0, emergency.length);
        Arrays.sort(sortedEmergency);

        for (int i=0; i<sortedEmergency.length; i++) {
            int e = sortedEmergency[i];
            ranks.put(e, sortedEmergency.length - i);
        }
        return ranks;
    }

    private static int[] getResult(int[] emergency, Map<Integer, Integer> rankMap) {
        int[] result = new int[emergency.length];
        for (int i=0; i<result.length; i++) {
            result[i] = rankMap.get(emergency[i]);
        }
        return result;
    }
}
