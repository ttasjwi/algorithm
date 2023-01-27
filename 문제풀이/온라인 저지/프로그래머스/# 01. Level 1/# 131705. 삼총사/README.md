# 문제
- 플랫폼 : 프로그래머스
- 번호 : 131705
- 제목 : 삼총사
- 난이도 : Level 1
- 학생들 중 삼총사(점수합이 0)를 만들 수 있는 방법의 수를 return 
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/131705" target="_blank">링크</a>

---

# 필요 지식
- 브루트포스

---

# 풀이

## 풀이1
```python
def solution(numbers):
    count = 0
    for i in range(len(numbers) - 2):
        for j in range(i + 1, len(numbers) - 1):
            for k in range(j+1, len(numbers)):
                if numbers[i] + numbers[j] + numbers[k] == 0:
                    count += 1
    return count
```
- 브루트포스
- 모두 싹 돌면서 합 계산

## 풀이2
```python
from itertools import combinations


def solution(number):
    return len([1 for comb in combinations(number, 3) if sum(comb) == 0])
```
- 마찬가지의 방법인데, 파이썬에는 combinations라는 유용한 함수가 있고, 이를 활용하면 간편하게 조합을 구할 수 있다.

---
