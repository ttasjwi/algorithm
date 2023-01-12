public class Solution2 {

    private static long[][] combinations;

    public long solution(int balls, int share) {
        combinations = new long[balls+1][balls+1];
        return combination(balls, share);
    }

    private long combination(int n, int r) {
        if (combinations[n][r] > 0) {
            return combinations[n][r];
        }
        if (r == 0 || r == n) {
            return combinations[n][0] = combinations[n][n] = 1;
        }
        if (r == 1 || r == n-1) {
            return combinations[n][1] = combinations[n][n-1] = n;
        }
        long result = combination(n-1, r-1);
        result *= n;
        result /= r;
        return combinations[n][r] = combinations[n][n-r] = result;
    }

}
