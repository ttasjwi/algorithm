public class Solution2 {
    public int[] solution(int n) {
        boolean[] checked = new boolean[n+1];

        int length = 0;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                checked[i] = true;
                length ++;
                if (n / i != i) {
                    checked[i] = true;
                    length ++;
                }
            }
        }

        int[] answer = new int[length];

        int index = 0;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (checked[i]) {
                answer[index] = i;
                if (n/i != i) {
                    answer[length-1-index] = n/i;
                }
                index ++;
            }
        }
        return answer;
    }

}
