public class Solution {

    public int solution(int order) {
        int answer = 0;

        int remainder;
        while(order>0) {
            remainder = order%10;
            if (remainder == 3 || remainder == 6 || remainder == 9) answer ++;
            order = order/10;
        }
        return answer;
    }
}
