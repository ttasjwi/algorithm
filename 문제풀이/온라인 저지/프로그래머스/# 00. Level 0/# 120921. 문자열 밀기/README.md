# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120921
- 제목 : 문자열 밀기
- 난이도 : Level 0
- A를 밀어서 B가 될 수 있다면 밀어야 하는 최소 횟수를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120921)

---

# 필요 알고리즘
- 문자열 처리

---

# Python
```python
def solution(a: str, b: str):
    return (b * 2).find(a)
```
- 문자열을 두 배로 늘린 다음, find 메서드로 a의 위치를 검색한다.
- 없으면 -1이 반환되고, 0번에서 찾아지면 같은 문자이며, 그 외의 경우에는 처음 등장한 인덱스가 반환된다.

---

# Java
```java
public class Solution {
    public int solution(String a, String b) {
        return new StringBuilder(b)
                .append(b)
                .indexOf(a);
    }
}

```

---
