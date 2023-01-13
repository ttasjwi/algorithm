public class Solution {

    public int solution(int[] numbers, int k) {
        int current = 0;
        for (int i=1; i<k; i++) {
            current = (current+2)%numbers.length;
        }
        return numbers[current];
    }
}
