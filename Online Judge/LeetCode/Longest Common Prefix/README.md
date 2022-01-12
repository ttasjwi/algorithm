---
# [LeetCode - 14] Longest Common Prefix

https://leetcode.com/problems/longest-common-prefix/

## 풀이
- StringBuilder 생성
- 0번째 문자를 builder에 추가
- 1번 인덱스부터 반복 순회하면서 다음을 확인한다. (1번 인덱스가 존재하지 않으면 다음으로 넘어감)
  - sb와 현재 문자열을 비교해서 둘중 짧은 길이만큼 sb를 잘라낸다.
  - 최대 sb.length() 회 만큼, 각 문자에 접근하여 다음을 반복한다.
    - sb의 문자와, 현재 문자의 문자를 비교했을 때 같은 위치의 문자가 다르면 동위치 이후의 모든 문자를 잘라낸다.
- sb.toString()을 반환한다.

```
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
```

---