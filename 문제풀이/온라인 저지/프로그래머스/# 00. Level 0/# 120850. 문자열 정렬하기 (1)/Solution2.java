public class Solution2 {
    public int[] solution(String my_string) {
        return my_string.chars()
                .filter(ch -> 48 <= ch && ch < 58)
                .map(ch -> ch - 48)
                .sorted()
                .toArray();
    }
}
