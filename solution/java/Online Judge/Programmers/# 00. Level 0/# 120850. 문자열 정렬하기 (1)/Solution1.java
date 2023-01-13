import java.util.Arrays;

public class Solution1 {
    public int[] solution(String my_string) {
        char[] chars = my_string.replaceAll("[a-zA-Z]", "").toCharArray();
        int[] numbers = new int[chars.length];

        for (int i=0; i<chars.length; i++) {
            numbers[i] = chars[i] - 48;
        }
        Arrays.sort(numbers);
        return numbers;
    }
}
