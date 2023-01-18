import java.util.Arrays;

public class Solution {

    public int solution(int[] numbers) {
        Arrays.sort(numbers);

        int product1 = numbers[0] * numbers[1];
        int product2 = numbers[numbers.length - 1] * numbers[numbers.length - 2];

        return Math.max(product1, product2);
    }

}
