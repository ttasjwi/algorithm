import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Solution2 {

    public String[] solution(String my_str, int n) {
        return IntStream.iterate(0, smallerThan(my_str), i -> i + n)
                .mapToObj(i -> getWord(my_str, n, i))
                .toArray(String[]::new);
    }

    private static IntPredicate smallerThan(String my_str) {
        return i -> i < my_str.length();
    }

    private static String getWord(String my_str, int n, int i) {
        int end = (i + n > my_str.length()) ? my_str.length() : i + n;
        return my_str.substring(i, end);
    }

}
