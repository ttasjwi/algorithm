public class Solution {

    public int solution(int n) {
        int number = 1;
        int factorial = 1;

        while (factorial <= n) {
            number++;
            factorial *= number;
        }
        return number-1;
    }

}
