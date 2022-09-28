# LeetCode 00049 : Group Anagrams
- 난이도 : Medium
- 문자열 배열을 받아서, 구성 문자가 같은 것끼리 그룹핑해서 반환하기
- 문제 : [링크](https://leetcode.com/problems/group-anagrams/)

---

# 풀이
```java
import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (int i=0; i< strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String anagram = String.valueOf(charArr);

            if (!anagrams.containsKey(anagram)) {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                anagrams.put(anagram, newList);
            } else {
                anagrams.get(anagram).add(strs[i]);
            }
        }
        return new ArrayList<>(anagrams.values());
    }

}
```
- 빈 해시맵을 생성한다.
- 문자열들을 얻어오고 `toCharArr()`로 배열화 시킨뒤, 정렬한 뒤, 문자열로 다시 변환한다.(애너그램)
- 애너그램이 맵에 있는지 확인하여 없으면 빈 리스트에, 문자열을 담아 angarams에 put한다.
- 있으면, 같은 애너그램 리스트를 얻어온뒤 리스트에 문자열을 담는다.
- 최종적으로 anagrams의 value들을 ArrayList에 담아 반환한다.

---
