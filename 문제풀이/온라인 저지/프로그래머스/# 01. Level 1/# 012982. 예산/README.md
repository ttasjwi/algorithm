# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012969
- 제목 : 예산
- 난이도 : Level 1
- 부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때, 최대 몇 개의 부서에 물품을 지원할 수 있는지 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12969" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘

---

# 풀이
```python
def solution(d, budget):
    d.sort()
    count = 0

    for value in d:
        if budget - value < 0:
            break
        else:
            budget -= value
            count += 1

    return count
```
- 배열을 정렬한다. (낮은 예산부터 순서대로 탐색한다.)
- 전체 예산에서 현재 인덱스의 요구 예산을 차감했을 때 0보다 크거나 같으면 해당 부서의 요구 예산을 승인한다.

---
