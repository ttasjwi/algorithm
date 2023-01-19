# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120896
- 제목 : 한 번만 등장한 문자
- 난이도 : Level 0
- 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120896)

---

# 필요 알고리즘
- 문자열 처리

---

# Python
```python
from collections import Counter


def solution(s):
    return ''.join(sorted([key for key, value in Counter(s).items() if value == 1]))
```
- Counter 객체는 아이템에 대한 빈도수를 계산해 딕셔너리로 반환한다.
- 딕셔너리의 `.items()` 함수를 사용하여, `dic_items()`를 얻어올 수 있다.
- 리스트 컴프리헨션을 통해 value가 1인 것들만 필터링하고, key를 요소로 한 리스트를 얻어온다.
- 이를 정렬하고 `''`으로 join하여 문자열로 반환한다.


---

# Java
```java
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
```
- 배열로 카운터를 구현한다.
- 카운팅을 끝내면 배열 맨 앞부터 순서대로 StringBuilder에 append 하므로, 정렬 문제도 해결된다.

---
