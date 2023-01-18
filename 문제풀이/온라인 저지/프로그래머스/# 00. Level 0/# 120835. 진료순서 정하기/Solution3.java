import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution3 {

    public int[] solution(int[] emergency) {
        List<Integer> sortedEmergency = Arrays
                .stream(emergency)
                .mapToObj(Integer::valueOf)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return Arrays.stream(emergency)
                .map(e -> sortedEmergency.indexOf(e) + 1)
                .toArray();
    }
}
