public class Solution {
    public int solution(int num, int k) {
        String strNum = String.valueOf(num);

        for (int i=0; i< strNum.length(); i++) {
            if (strNum.charAt(i) == (k+48)) {
                return i+1;
            }
        }
        return -1;
    }
}
