import java.util.Arrays;

public class Solution2 {
    public double solution(int[] numbers) {
        return Arrays.stream(numbers)
                .average()
                .getAsDouble();
    }
}
