
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        sb.append(strs[0]); // 첫번째 문자를 전부 StringBuilder에 넣는다.
        for (int i=1; i<strs.length; i++) {
            sb.setLength(Integer.min(sb.length(), strs[i].length())); // sb와 현재 문자를 비교해서 작은 길이만큼 남기고 잘라낸다.
            for (int j=0; j<sb.length(); j++) {
                if (sb.charAt(j) != strs[i].charAt(j)) { // 자리별로 순차적으로 길이를 비교하였을 때, 현재 문자가 sb의 같은 위치 문자가 다르면
                    sb.delete(j, sb.length()); // 동위치 이후의 모든 문자를 잘라낸다.
                }
            }
        }
        return sb.toString();
    }
}