class Solution {
    public String solution(String s) {
        int[] counter = new int[26];

        for (char ch : s.toCharArray()) {
            counter[ch - 97]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 1) sb.append((char) (i + 97));
        }
        return sb.toString();
    }
}
