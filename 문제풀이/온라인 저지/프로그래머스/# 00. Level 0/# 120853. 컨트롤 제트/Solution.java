public class Solution {
    public int solution(String s) {

        int before = 0;
        int answer = 0;

        for (String word : s.split(" ")) {
            if (word.equals("Z")) {
                answer -= before;
            } else {
                before = Integer.parseInt(word);
                answer += before;
            }
        }
        return answer;
    }
}
