public class Solution1 {
    public int solution(int[] sides) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int side : sides) {
            sum += side;
            if (side > max) {
                max = side;
            }
        }
        return (max < sum - max)
                ? 1
                : 2;

    }
}
