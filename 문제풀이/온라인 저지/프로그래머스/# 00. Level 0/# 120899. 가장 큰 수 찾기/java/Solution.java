public class Solution {
    public int[] solution(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i=0; i<array.length; i++) {
            if (maxValue < array[i]) {
                maxValue = array[i];
                maxIndex = i;
            }
        }
        return new int[]{maxValue, maxIndex};
    }
}
