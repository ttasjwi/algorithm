public class Solution2 {

    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        for (int number : num_list) {
            answer[number%2] ++;
        }
        return answer;
    }

}
