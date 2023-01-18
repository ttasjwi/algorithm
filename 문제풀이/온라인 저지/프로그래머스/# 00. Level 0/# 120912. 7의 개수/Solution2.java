import java.util.Arrays;

public class Solution2 {
    public int solution(int[] array) {
        return Arrays.stream(array)
                .map(this::countSeven)
                .sum();
    }

    private int countSeven(int number) {
        int count = 0;
        while (number > 0) {
            if (number%10 == 7) {
                count ++;
            }
            number /= 10;
        }
        return count;
    }
}
