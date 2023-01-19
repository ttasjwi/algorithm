import java.util.Arrays;

public class Solution2 {
    public int[] solution(int n, int[] numlist) {
        return Arrays.stream(numlist)
                .filter(num -> num%n == 0)
                .toArray();
    }
}
