# LeetCode 00049 : Group Anagrams
- 난이도 : Medium
- 문자열 배열을 받아서, 구성 문자가 같은 것끼리 그룹핑해서 반환하기
- 문제 : [링크](https://leetcode.com/problems/group-anagrams/)

---

# 풀이
```python
import collections
from typing import List

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = collections.defaultdict(list) # 디폴트 딕셔너리

        for word in strs:
            anagrams[''.join(sorted(word))].append(word)
        return list(anagrams.values())

```
- 기본값으로 빈 리스트를 갖는 defaultdict를 생성한다.
- 각 문자를 정렬한 뒤(angram), angram의 value에 위치한 리스트에 원본 문자열을 append하는 것을 반복한다.
- 결과 defaultdict의 `values()`들을 얻어온 뒤, 이를 다시 리스트로 변환하고, 반환한다.


---
