public class Solution2 {

    public String solution(String my_string) {
        char[] chars = my_string.toCharArray();

        int lt = 0;
        int rt = chars.length - 1;
        char tmp;

        while (lt < rt) {
            tmp = chars[lt];
            chars[lt] = chars[rt];
            chars[rt] = tmp;

            lt ++;
            rt --;
        }
        return String.valueOf(chars);
    }
}
