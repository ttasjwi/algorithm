public class Solution1 {
    public String solution(int age) {
        char[] chars = String.valueOf(age).toCharArray();

        for (int i=0; i<chars.length; i++) {
            chars[i] = (char)(chars[i]+49);
        }

        return String.valueOf(chars);
    }
}
