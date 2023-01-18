import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {

    public int solution(int[] array, int n) {
        return Arrays.stream(array)
                .mapToObj(Integer::valueOf)
                .min(Comparator.comparing(x-> Math.abs(n - (int) x)).thenComparing(x-> (int) x-n))
                .get();
    }
}
