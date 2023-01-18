public class Solution {

    public int solution(int i, int j, int k) {
        int answer = 0;

        int number;
        for (int n = i; n<= j; n++) {

            number = n;

            while (number > 0) {
                if (number%10 == k) {
                    answer ++;
                }
                number = number/10;
            }
        }

        return answer;
    }

}
