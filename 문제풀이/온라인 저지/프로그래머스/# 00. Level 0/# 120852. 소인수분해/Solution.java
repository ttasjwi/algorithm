import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] solution(int n) {
        boolean[] isCompositeNumber = new boolean[n+1];
        List<Integer> primeNumbers = new ArrayList<>();

        for (int i = 2; i<= n; i++) {
            if (!isCompositeNumber[i]) {
                if (n%i == 0) {
                    primeNumbers.add(i);
                }
                for (int j = 2*i; j<= n; j+=i) {
                    if (!isCompositeNumber[j]) {
                        isCompositeNumber[j] = true;
                    }
                }
            }
        }

        return primeNumbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
