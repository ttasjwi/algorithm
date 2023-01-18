public class Solution1 {

    public int[] solution(int[] num_list) {
        int evenCount = 0; // 짝수
        int oddCount = 0; // 홀수

        for (int number : num_list) {
            if (number%2 == 0) {
                evenCount ++;
            } else {
                oddCount ++;
            }
        }
        return new int[]{evenCount, oddCount};
    }

}
