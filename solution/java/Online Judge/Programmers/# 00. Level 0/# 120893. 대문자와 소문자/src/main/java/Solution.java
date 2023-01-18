public class Solution {

    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();

        for (int ch : my_string.toCharArray()) {
            if (97 <= ch && ch <= 122) {
                sb.append((char) (ch - 32));
            } else {
                sb.append((char) (ch + 32));
            }
        }
        return sb.toString();
    }
}
