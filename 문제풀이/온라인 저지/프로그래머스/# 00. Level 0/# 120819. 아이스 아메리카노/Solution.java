public class Solution {

    private static final int PRICE = 5500;

    public int[] solution(int money) {
        int count = money/PRICE;
        int change = money%PRICE;
        return new int[]{count, change};
    }
}
