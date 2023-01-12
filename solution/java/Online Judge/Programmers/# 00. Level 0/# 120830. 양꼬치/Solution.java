public class Solution {

    private static final int LAMB_PRICE = 12000;
    private static final int DRINK_PRICE = 2000;
    public int solution(int n, int k) {
        return calculateLambPrice(n) + calculateDrinkPrice(k) - calculateDiscountPrice(n);
    }

    private static int calculateLambPrice(int n) {
        return n * LAMB_PRICE;
    }

    private static int calculateDrinkPrice(int k) {
        return k * DRINK_PRICE;
    }

    private int calculateDiscountPrice(int n) {
        return (n/10) * DRINK_PRICE;
    }
}
