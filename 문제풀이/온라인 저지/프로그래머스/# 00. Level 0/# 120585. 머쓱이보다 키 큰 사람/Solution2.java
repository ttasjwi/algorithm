import java.util.Arrays;

public class Solution2 {

    public int solution(int[] array, int height) {
        return (int) Arrays.stream(array)
                .filter(h -> h > height)
                .count();
    }
}
