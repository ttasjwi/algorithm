public class Solution {

    public String solution(String s) {

        StringBuilder sb = new StringBuilder();

        char[] chars = s.toCharArray();

        int index = 0;

        for (char ch : chars) {
            if (ch == ' ') {
                index = 0;
                sb.append(' ');
            } else if (index++%2 == 0) {
                if (97<=ch&& ch<=122) { // 소문자이면 대문자화
                    sb.append((char)(ch-32));
                } else {
                    sb.append(ch);
                }
            } else {
                if (65 <= ch && ch <= 90) {
                     sb.append((char)(ch+32));
                } else {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }

}