import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public int[] solution(int[] answers) {
        int[] counter = counting(answers);

        Map<Integer, Integer> counts = new HashMap<>();

        int max = Integer.MIN_VALUE;

        for (int i=0; i< counter.length; i++) {
            counts.put(i, counter[i]);
            if (counter[i] > max) max = counter[i];
        }

        int finalMax = max;

        return counts.entrySet().stream()
                .filter(e -> e.getValue() == finalMax)
                .map(Map.Entry::getKey)
                .mapToInt(k -> k + 1)
                .toArray();
    }

    private int[] counting(int[] answers) {
        int[] counter = new int[3];

        int[][] patterns = {
                {1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };

        for (int i = 0; i< answers.length; i ++) { // 각 문제별로
            for (int j=0; j<patterns.length; j++) {
                if(patterns[j][i%patterns[j].length] == answers[i])
                    counter[j] ++;
            }
        }
        return counter;
    }

}