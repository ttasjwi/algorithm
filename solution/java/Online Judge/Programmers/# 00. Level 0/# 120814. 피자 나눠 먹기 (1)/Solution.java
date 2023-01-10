public class Solution {

    public int solution(int n) {
        int share = n/7;
        int remainder = n%7;

        return (remainder > 0) ? share + 1 : share;
    }
}
