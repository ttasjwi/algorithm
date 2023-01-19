import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(String[] s1, String[] s2) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        for (String s : s1) {
            set1.add(s);
        }

        for (String s : s2) {
            set2.add(s);
        }

        set1.retainAll(set2);
        return set1.size();
    }

}
