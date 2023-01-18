public class Solution2 {

    public int solution(int[] array, int n) {

        int diff;
        int minDiff = Integer.MAX_VALUE;
        int answer = -1;

        for (int i : array) {
            diff = Math.abs(n - i);

            if (minDiff > diff) {
                minDiff = diff;
                answer = i;
            } else if (minDiff == diff) {
                if (answer > i) {
                    answer = i;
                }
            }
        }

        return answer;
    }
}
