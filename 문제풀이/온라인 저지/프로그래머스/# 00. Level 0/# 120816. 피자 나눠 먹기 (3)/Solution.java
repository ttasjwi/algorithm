
public class Solution {
    public int solution(int slice, int n) {
        int share = n/slice;
        int remainder = n%slice;
        return (remainder > 0) ? share + 1 : share;
    }
}
