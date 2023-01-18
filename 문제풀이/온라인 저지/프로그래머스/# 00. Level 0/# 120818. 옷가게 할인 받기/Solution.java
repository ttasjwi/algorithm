
class Solution {
    public int solution(int price) {
        double discountPercent = getDiscountPercent(price);
        return (int) (price * (1- discountPercent));
    }

    private double getDiscountPercent(int price) {
        if (price >= 500000) return 0.2;
        else if (price >= 300000) return 0.1;
        else if (price >= 100000) return 0.05;
        else return 0;
    }
}
