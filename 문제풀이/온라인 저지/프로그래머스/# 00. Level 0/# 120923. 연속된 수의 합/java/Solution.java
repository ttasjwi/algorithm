public class Solution {

    public int[] solution(int num, int total) {
        int average = total / num;
        int lt = average - (num - 1) / 2;

        int[] answer = new int[num];
        for (int i = 0; i < num; i++) {
            answer[i] = i + lt;
        }
        return answer;
    }

}
