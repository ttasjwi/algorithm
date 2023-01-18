public class Solution1 {

    public int solution(String my_string) {
        int sum = 0;
        for (char ch : my_string.toCharArray()) {
            if (48 <= ch && ch < 58) {
                sum += ch-48;
            }
        }
        return sum;
    }
}
