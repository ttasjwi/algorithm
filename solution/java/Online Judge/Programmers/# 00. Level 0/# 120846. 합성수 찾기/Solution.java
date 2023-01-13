public class Solution {

    public int solution(int n) {
        boolean[] isCompositeNumber = new boolean[n+1];
        int answer = 0;

        for (int i = 2; i<= n; i++) {
            if (!isCompositeNumber[i]) {
                for (int j = 2*i; j<= n; j+=i) {
                    if (!isCompositeNumber[j]) {
                        isCompositeNumber[j] = true;
                        answer ++;
                    }
                }
            }
        }
        return answer;
    }

}
