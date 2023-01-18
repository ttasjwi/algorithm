import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution2 {

    public int[] solution(int[] numlist, int n) {
        List<Integer> numbers = new ArrayList<>();

        for (int i : numlist) {
            numbers.add(i);
        }

        numbers.sort(myComparator(n));

        int[] answer = new int[numbers.size()];

        for (int i=0; i<numbers.size(); i++) {
            answer[i] = numbers.get(i);
        }
        return answer;
    }

    private Comparator<Integer> myComparator(int n) {
        return (a, b) -> {
            int aDiff = Math.abs(a - n);
            int bDiff = Math.abs(b - n);

            if (aDiff == bDiff) {
                return b - a;
            }
            return aDiff - bDiff;
        };
    }

}
