public class Solution {

    public int solution(int n) {
        double sqrt = Math.sqrt(n);
        return (sqrt == (int) sqrt) ? 1 : 2;
    }
}
