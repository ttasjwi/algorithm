public class Solution {

    public boolean isPalindrome(int x) {
        if (x<0) return false;
        char[] chars = String.valueOf(x).toCharArray();

        int middleIndex = chars.length >> 1;

        for (int i=0; i<middleIndex; i++) {
            if (chars[i] != chars[chars.length-1-i]) return false;
        }
        return true;
    }
}