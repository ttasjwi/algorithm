import java.util.*;

public class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }
}
