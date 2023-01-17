public class Solution {
    public int solution(int n) {
        int number = 1;

        while (n > 0) {
            if (isValidNumber(number)) {
                n --;
            }
            number ++;
        }
        return number - 1;
    }

    private boolean isValidNumber(int number) {
        int sum = 0;
        for (char ch : String.valueOf(number).toCharArray()) {
            if (ch == 51) {
                return false;
            }
            sum += ch - 48;
        }
        return (sum % 3 != 0);
    }

}
