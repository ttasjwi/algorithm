import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Solution2 {

    public int[] solution(int[] num_list) {
        var numbers = Arrays.stream(num_list)
                .boxed()
                .collect(Collectors.toList());

        Collections.reverse(numbers);

        return numbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
