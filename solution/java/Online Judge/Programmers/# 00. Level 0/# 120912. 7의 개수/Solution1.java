public class Solution1 {
    public int solution(int[] array) {
        int answer = 0;
        for (int number : array) {
            answer += countSeven(number);
        }
        return answer;
    }

    private int countSeven(int number) {
        int count = 0;
        while (number > 0) {
            if (number%10 == 7) {
                count ++;
            }
            number /= 10;
        }
        return count;
    }
}
