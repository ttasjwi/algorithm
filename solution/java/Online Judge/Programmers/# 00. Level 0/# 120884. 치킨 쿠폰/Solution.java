public class Solution {

    public int solution(int coupon) {
        int bonus;
        int bonusSum = 0;

        while ((bonus = coupon/10) > 0) {
            bonusSum += bonus;
            coupon = coupon%10 + bonus;
        }
        return bonusSum;
    }
}
