import java.util.stream.Collectors;

public class Solution2 {
    public String solution(int age) {
        return String.valueOf(age)
                .chars()
                .mapToObj(ch -> String.valueOf((char)(ch + 49)))
                .collect(Collectors.joining());
    }
}
