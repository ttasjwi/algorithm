# LeetCode 00937 : Reorder Data in Log Files
- 난이도 : Easy
- 문제에서 제시한 정렬 기준에 따라 리스트 정렬하기
- 문제 : [링크](https://leetcode.com/problems/reorder-data-in-log-files/)

---

# 풀이
```python
from typing import List


class Solution:

    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        letters, digits = [], []

        for log in logs:
            if log.split()[1].isdigit():
                digits.append(log)
            else:
                letters.append(log)
        letters.sort(key=lambda x: (x.split()[1:], x.split()[0]))
        return letters + digits


```
- 우선 리스트를 순차적으로 읽어, 공백 분리 기준 1번 인덱스에 위치한 문자열이 영문자인지, 숫자인지에 따라 분리한다.
- 영문자 배열 목록을 정렬한다.
  - 공백 분리 기준 1번 이후 문자열에 따라 정렬하고, 같은 경우 식별자 기준으로 정렬한다.
  - 이 때 리스트의 sort 메서드에서 람다, 튜플을 사용하면 정렬 기준을 편리하게 지정할 수 있다.

---
