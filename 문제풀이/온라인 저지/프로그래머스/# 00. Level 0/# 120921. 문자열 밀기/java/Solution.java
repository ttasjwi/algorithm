public class Solution {
    public int solution(String a, String b) {
        return new StringBuilder(b)
                .append(b)
                .indexOf(a);
    }
}
