import java.util.stream.Collectors;

public class Solution2 {
    public String solution(String my_string) {
        return my_string.chars()
                .distinct()
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }
}
