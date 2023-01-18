public class Solution1 {

    private int answer;

    public int solution(String my_string) {
        char[] chars = my_string.toCharArray();
        int index = 0;
        while (index < chars.length) {
            index = calculate(chars, index);
        }
        return answer;
    }

    public int calculate(char[] chars, int startIndex) {
        int value = 0;
        int index = startIndex;
        char current;

        while (index < chars.length) {
            current = chars[index];
            if (48 <= current && current < 58) {
                value = value * 10 + current - 48;
                index ++;
            } else {
                index ++;
                break;
            }
        }
        answer += value;
        return index;
    }

}
