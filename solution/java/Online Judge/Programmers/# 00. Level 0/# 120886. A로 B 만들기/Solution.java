public class Solution {

    public int solution(String before, String after) {
        int[] counter = new int[26];

        for (char ch : before.toCharArray()) {
            counter[ch-97]++;
        }
        for (char ch : after.toCharArray()) {
            if (counter[ch-97] == 0) {
                return 0;
            } else {
                counter[ch-97] --;
            }
        }

        return 1;
    }

}
