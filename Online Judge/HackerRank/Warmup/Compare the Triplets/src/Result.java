import java.util.ArrayList;
import java.util.List;

public class Result {

    /*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */


    private static final int TRIPLET_SIZE = 3; // Triplet의 size

    // 두 triplet을 비교한 점수의 배열을 반환한다.
    public static List<Integer> compareTriplets(List<Integer> triplet_A, List<Integer> triplet_B) {
        List<Integer> scores = new ArrayList<>();
        int score_a = 0;
        int score_b = 0;

        for (int i=0; i<TRIPLET_SIZE; i++) {
            int element_a = triplet_A.get(i);
            int element_b = triplet_B.get(i);

            if (element_a > element_b) score_a ++;
            else if (element_a < element_b) score_b ++;
        }

        scores.add(score_a);
        scores.add(score_b);
        return scores;
    }

}