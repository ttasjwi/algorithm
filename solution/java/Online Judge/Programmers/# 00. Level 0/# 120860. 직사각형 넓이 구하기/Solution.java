public class Solution {

    public int solution(int[][] dots) {
        return calculateWidth(dots) * calculateHeight(dots);
    }

    private int calculateWidth(int[][] dots) {
        int xDiff1 = Math.abs(dots[0][0] - dots[1][0]);
        int xDiff2 = Math.abs(dots[2][0] - dots[1][0]);
        return Math.max(xDiff1, xDiff2);
    }

    private int calculateHeight(int[][] dots) {
        int yDiff1 = Math.abs(dots[0][1] - dots[1][1]);
        int yDiff2 = Math.abs(dots[2][1] - dots[1][1]);
        return Math.max(yDiff1, yDiff2);
    }
}
