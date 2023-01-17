public class Solution {
    public int solution(String[] spells, String[] dic) {
        int count;

        for (String word : dic) {
             count = spells.length;
            for (String spell : spells) {
                if (word.contains(spell)) {
                    count--;
                }
            }
            if (count == 0) {
                return 1;
            }
        }
        return 2;
    }

}
