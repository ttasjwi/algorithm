# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120909
- 제목 : 제곱수 판별하기
- 난이도 : Level 0
- 정수 n이 매개변수로 주어질 때, n이 제곱수라면 1을 아니라면 2를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120909)

---

# 필요 알고리즘
- Math.sqrt 를 아는가?

---

# 풀이
```java
public class Solution {

    public int solution(int n) {
        double sqrt = Math.sqrt(n);
        return (sqrt == (int) sqrt) ? 1 : 2;
    }
}
```
```python
from math import sqrt


def solution(n):
    sqrt_n = sqrt(n)
    return 1 if sqrt_n == int(sqrt_n) else 2

```
- sqrt 함수를 통해 제곱근을 구하고, 이 값을 정수화시킨 것과 비교하여 값이 같으면 제곱수이다.

---
