public class Solution {

    public int solution(int[] sides) {
        int otherMax = (sides[0] >= sides[1]) ? sides[0] : sides[1];

        int number = 1;
        int sum = sides[0] + sides[1] + 1;
        int max = (number >= otherMax) ? number : otherMax;

        int answer = 0;

        // 조건 : max < sum - max

        while (true) {
            if (max < sum - max) {
                answer ++;
                System.out.printf("%d, %d, %d%n", sides[0], sides[1], number);
            } else if (max == number){
                break;
            }
            number ++;
            sum++;
            max = (number >= otherMax) ? number : otherMax;
        }

        return answer;
    }

}
