import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution2 {

    public int[] solution(int[][] scores) {
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i< scores.length; i++) {
            sums.add(scores[i][0] + scores[i][1]);
        }
        sums.sort(Comparator.reverseOrder());

        int[] ranks = new int[scores.length];

        for (int i=0; i<ranks.length; i++) {
            ranks[i] = sums.indexOf(scores[i][0] + scores[i][1])+1;
        }

        return ranks;
    }

}
