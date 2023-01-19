class Solution2 {
    public int solution(String my_string) {
        my_string = my_string.replaceAll(" ", "");
        int answer = 0;
        boolean isPlus = true;
        int value = 0;
        for (char ch : my_string.toCharArray()) {
            if (48 <= ch && ch < 58) {
                value = value * 10 + (ch - 48);
            } else {
                answer += (isPlus) ? value : -value;
                value = 0;
                isPlus = (ch == '+');
            }
        }
        answer += (isPlus) ? value : -value;
        return answer;

    }
}
