# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012928
- 제목 : 약수의 합
- 난이도 : Level 1
- n의 약수를 모두 더한 값을 리턴
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/12928)

---

# 필요 지식
- 약수 구하기 : 제곱근까지 반복 돌리기로 시간 단축 가능!

---

# Java
```java
public class Solution {

    public int solution(int n) {
        int answer = 0;
        for (int i=1; i<=Math.sqrt(n); i++) {
            if (n%i == 0) {
                answer += i;
                if (i != n/i) {
                    answer += n/i;
                }
            }
        }
        return answer;
    }
}
```
- 1부터 n의 제곱근 이하까지 순회하면서 판별하면 된다.
- 나눴을 때 나누어 떨어지면, 몫 역시 약수가 된다.
- 이 때, 나눈 수와 몫이 같은 경우에는 중복되므로 몫을 더해선 안 된다.

---

# Python
```python
from math import sqrt


def solution(n):
    answer = 0
    for i in range(1, int(sqrt(n)) + 1):
        if n%i == 0:
            answer += i
            if i != n//i:
                answer += n//i

    return answer
```
- java와 같은 방법으로 가능하다.

---
