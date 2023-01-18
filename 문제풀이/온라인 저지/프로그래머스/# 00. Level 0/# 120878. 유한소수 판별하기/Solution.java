public class Solution {

    public int solution(int a, int b) {
        if (a == b) return 1;
        int max, min;

        if (a > b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }

        b /= gcd(max, min);

        while (b % 2 == 0) {
            b /= 2;
        }

        while (b % 5 == 0) {
            b /= 5;
        }

        return (b == 1)
                ? 1
                : 2;
    }

    private int gcd(int max, int min) {
        int r = max % min;
        return (r == 0)
                ? min
                : gcd(min, r);
    }

}
