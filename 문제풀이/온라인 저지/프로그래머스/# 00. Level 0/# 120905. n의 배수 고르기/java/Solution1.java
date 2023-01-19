import java.util.ArrayList;

public class Solution1 {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int num : numlist) {
            if (num%n == 0) {
                numbers.add(num);
            }
        }
        int[] answer = new int[numbers.size()];

        for (int i=0; i<numbers.size(); i++) {
            answer[i]= numbers.get(i);
        }
        return answer;
    }
}
