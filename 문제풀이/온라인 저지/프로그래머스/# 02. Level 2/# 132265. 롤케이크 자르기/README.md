# 문제
- 플랫폼 : 프로그래머스
- 번호 : 132265
- 제목 : 롤케이크 자르기
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/132265" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```python
from collections import Counter

def solution(topping):
    counter_a = Counter({})
    counter_b = Counter(topping)

    answer = 0

    for item in topping:
        if item not in counter_a:
            counter_a[item] = 1
        else:
            counter_a[item] += 1

        if counter_b[item] == 1:
            counter_b.pop(item)
        else:
            counter_b[item] -= 1

        if len(counter_a) == len(counter_b):
            answer += 1
    
    return answer
```
- 해시 테이블을 통해 철수/동생 각각이 가진 토핑의 갯수를 카운팅한다.
  - counter_a : 철수의 토핑 갯수 / counter_b : 동생의 토핑 갯수
- 우선 counter_b 에 토핑을 전부 몰아넣어서 카운팅한다.
- 그 후 toppings를 순서대로 탐색하면서, 반대쪽에 하나씩 토핑을 덜어준다. 이때 counter_b 측에서 토핑 갯수가 0이 된 key는 제거한다.
- 매 순간 각각이 가진 토핑의 종류 갯수를 비교하고 같으면 answer 를 증가시킨다.

---
