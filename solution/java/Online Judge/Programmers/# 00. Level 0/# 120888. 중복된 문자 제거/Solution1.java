public class Solution1 {
    public String solution(String my_string) {
        boolean spaceIncluded = false;
        boolean[] lowerChecked = new boolean[26];
        boolean[] upperChecked = new boolean[26];

        StringBuilder sb = new StringBuilder();

        for (char ch : my_string.toCharArray()) {
            if (ch == ' ') {
                if (!spaceIncluded) {
                    sb.append(ch);
                    spaceIncluded = true;
                }
                continue;
            }

            if (65 <= ch && ch <= 90) {
                if (!upperChecked[ch-65]) {
                    sb.append(ch);
                    upperChecked[ch-65] = true;
                }
                continue;
            }

            if (97 <= ch && ch <= 122) {
                if (!lowerChecked[ch-97]) {
                    sb.append(ch);
                    lowerChecked[ch-97] = true;
                }
            }
        }
        return sb.toString();
    }
}
