public class Solution2 {
    public int solution(int n) {
        return lcm(n, 6) / 6;
    }

    public int gcd(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int r = max % min;

        return (r == 0)
                ? min
                : gcd(min, r);
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
