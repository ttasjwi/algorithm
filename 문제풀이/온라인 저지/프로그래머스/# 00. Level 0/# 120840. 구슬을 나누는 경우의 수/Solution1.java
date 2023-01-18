public class Solution1 {

    private int[][] combinations;

    public int solution(int balls, int share) {
        combinations = new int[balls+1][balls+1];
        return combination(balls, share);
    }

    private int combination(int n, int r) {
        if (combinations[n][r] > 0) {
            return combinations[n][r];
        }
        if (r == 0 || r == n) {
            return combinations[n][0] = combinations[n][n] = 1;
        }
        if (r == 1 || r == n-1) {
            return combinations[n][1] = combinations[n][n-1] = n;
        }
        return combinations[n][r] = combinations[n][n-r] = combination(n-1, r-1) + combination(n-1, r);
    }

}
