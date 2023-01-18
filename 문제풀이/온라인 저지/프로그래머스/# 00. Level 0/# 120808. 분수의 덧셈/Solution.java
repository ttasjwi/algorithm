public class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int bottom = denom1 * denom2;
        int top = numer1 * denom2 + numer2 * denom1;

        int gcd = gcd(bottom, top);

        return new int[]{top/gcd, bottom/gcd};
    }

    private int gcd(int a, int b) {
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        int r = max%min;

        return (r == 0)
                ? min
                : gcd(min, r);
    }
}
