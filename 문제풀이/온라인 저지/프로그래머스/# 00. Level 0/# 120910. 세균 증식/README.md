# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120910
- 제목 : 세균 증식
- 난이도 : Level 0
- t시간 후 세균의 수를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120910)

---

# 필요 알고리즘
- 비트 연산

---

# 풀이
```java
public class Solution {
    public int solution(int n, int t) {
        return n << t;
    }

}
```
```python
def solution(n, t):
    return n << t
```
- n이 초당 2배씩 늘어나므로, t초가 지나면 2**t 배 증가한다.
- 그런데, 2배씩 증가시키는 것은 비트를 왼쪽으로 1번씩 미는 것과 구조적으로 동일하다.
- 따라서 t번 비트를 왼쪽으로 밀면 된다.

---
