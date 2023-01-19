import java.util.LinkedList;

public class Solution1 {
    public int[] solution(int n) {
        LinkedList<Integer> numbers = new LinkedList<>();

        int idx = 0;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                numbers.add(idx, i);
                if (n / i != i) {
                    numbers.add(idx + 1, n / i);
                }
                idx++;
            }
        }
        int[] answer = new int[numbers.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = numbers.pop();
        }
        return answer;
    }
}
