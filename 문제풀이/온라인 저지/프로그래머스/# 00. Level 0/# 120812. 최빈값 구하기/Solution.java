import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solution(int[] array) {
        Map<Integer, Integer> counter = counting(array);
        return getAnswer(counter);
    }

    private static Map<Integer, Integer> counting(int[] array) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int number : array) {
            counter.put(number, counter.getOrDefault(number, 0)+ 1);
        }
        return counter;
    }

    private static int getAnswer(Map<Integer, Integer> counter) {
        int answer = -1;
        int maxCount = -1;

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int number = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                maxCount = count;
                answer = number;
            } else if (count == maxCount) {
                answer = -1;
            }
        }
        return answer;
    }
}
