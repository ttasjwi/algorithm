public class Solution2 {

    public int solution(int n) {
        int answer = 0;
        for (int ch : String.valueOf(n).toCharArray()) {
            answer += ch - 48;
        }
        return answer;
    }
}
