
public class Solution {
    public int reverse(int x) {
        boolean isNegative = x<0;

        int absX = (isNegative)? -x : x;
        long answer = 0;

        while(absX > 0) {
            answer *= 10;
            answer += absX%10;
            absX /= 10;
        }
        if (answer > Integer.MAX_VALUE) {
            answer = 0;
        }
        return (isNegative)? -(int)answer : (int)answer;
    }

}