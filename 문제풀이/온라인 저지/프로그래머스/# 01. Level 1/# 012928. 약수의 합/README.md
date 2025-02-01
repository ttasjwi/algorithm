# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012928
- 제목 : 약수의 합
- 난이도 : Level 1
- 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12928" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
```python
import math

def solution(n):
    sum = 0
    for i in range(1, int(math.sqrt(n)) + 1):
        q, r = divmod(n, i)
        if r == 0:
            sum += i
            if q != i:
                sum += q
    return sum
```
- 1 부터 n의 제곱근(정수) 이하까지 따진다.
- 나누어 떨어지면 나누는 수(제수)는 약수이다. 이 때 몫 역시 약수가 된다.
- 다만 n 이 완전제곱수일 경우 나누는 수와 몫이 같아진다. 이 경우는 두번 더하지 않도록 주의해야한다.

---
