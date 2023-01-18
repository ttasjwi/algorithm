import java.util.stream.IntStream;

public class Solution2 {
    public int[] solution(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(number -> number % 2 == 1)
                .toArray();
    }
}
