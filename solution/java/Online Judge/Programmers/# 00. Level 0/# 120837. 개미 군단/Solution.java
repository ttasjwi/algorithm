public class Solution {

    private static final int[] attacks = new int[]{5, 3, 1};

    public int solution(int hp) {
        int answer = 0;

        for (int attack : attacks) {
            answer += hp / attack;
            hp = hp % attack;

            if (hp == 0) {
                break;
            }
        }
        return answer;
    }
}
