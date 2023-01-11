import java.util.Arrays;

public class Solution2 {

    public int solution(int[] array, int n) {
        return (int) Arrays.stream(array)
                .filter(number -> number == n)
                .count();
    }
}
