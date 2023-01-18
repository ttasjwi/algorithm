public class Solution1 {
    public int[] solution(int n) {
        int length = (n % 2 == 0)
                ? n / 2
                : n / 2 + 1;

        int[] answer = new int[length];
        for (int i=0; i<length; i++) {
            answer[i] = 2*i + 1;
        }
        return answer;
    }
}
