# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012936
- 제목 : 줄 서는 방법
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12936" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```python
def solution(n, k):
    factorials = [0] * n
    factorials[0] = 1
    for i in range(1, n):
        factorials[i] = factorials[i - 1] * i
    nums = [i for i in range(1, n + 1)] # 1,2,3,...n
    answer = []

    while n > 0:
        idx = (k - 1) // factorials[n - 1] # 추출할 인덱스 계산
        answer.append(nums.pop(idx)) # 추출
        k %= factorials[n - 1] # k 를 (n-1)! 로 나눈 나머지만큼 k 는 남음
        n -= 1
    return answer
```
- 대상들을 줄 새울 때 (n-1)! 번 줄 세우는 것이 n 번 반복되는 구조다.
- 다음을 반복한다.
  - idx : (k-1) 을 (n-1)! 로 나눈 몫을 구한다. 이 값이 추출할 인덱스다.
  - nums 에서 idx 번째 요소를 추출 후 answer 에 추가한다.
  - k 는 (n-1)! 로 나눈 나머지로 재할당한다.
  - n 을 1 감소시킨다.
- 최종적으로 answer 를 반환한다.

---
