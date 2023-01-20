# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120924
- 제목 : 다음에 올 숫자
- 난이도 : Level 0
- 등차수열 혹은 등비수열 common이 매개변수로 주어질 때, 마지막 원소 다음으로 올 숫자를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120924" target="_blank">링크</a>

---

# 필요 알고리즘
- 수학(수열)

---

# Python
```python
def solution(common):
    d = common[1] - common[0]

    # 등차 판별
    if d == common[2] - common[1]:
        return common[-1] + d

    # 등비
    if common[0] == 0:
        return 0

    return common[-1] * (common[1]//common[0])
```
- 0-1항차, 1-2항차 비교 후 같으면 등차수열이다.
- 아니면 공비를 끝 항에 곱해줘야한다.
- 우선, 첫 항이 0인 등비수열인 경우를 고려해야한다. 하지만 이 문제에서는 대상 케이스가 되지 않는다. 첫항이 0이면 모든 항이 0일테고 이미 등차수열로
판별되었기 때문에 이 케이스는 고려하지 않아도 되기 때문이다. 하지만 나는 코드의 명확성을 좋아하기 때문에 이 판별 로직을 명시적으로 작성했다.
- 그 외에는 정상적으로 공비를 계산할 수 있으므로 끝항에 공비(연속한 두 항의 비)를 곱한다.

---
