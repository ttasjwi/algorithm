public class Solution1 {

    public int solution(int[] array, int n) {
        int answer = 0;
        for (int number : array) {
            if (number == n) {
                answer ++;
            }
        }
        return answer;
    }
}
