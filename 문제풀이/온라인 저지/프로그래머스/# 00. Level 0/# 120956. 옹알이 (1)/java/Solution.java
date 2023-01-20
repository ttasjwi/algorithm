public class Solution {

    public int solution(String[] babbling) {
        int answer = 0;
        for (String word : babbling) {
            if (speakable(word)) {
                answer ++;
            }
        }
        return answer;
    }

    private boolean speakable(String word) {
        return word.replace("aya", " ")
                .replace("ye", " ")
                .replace("woo", " ")
                .replace("ma", " ")
                .isBlank();
    }

}
