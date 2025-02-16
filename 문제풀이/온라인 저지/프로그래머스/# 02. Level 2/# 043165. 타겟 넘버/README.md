# 문제
- 플랫폼 : 프로그래머스
- 번호 : 043165
- 제목 : 타겟 넘버
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/43165" target="_blank">링크</a>

---

# 필요 지식
- DFS

---

# 풀이
```python
def solution(numbers, target):
    answer = 0

    def dfs(idx, cur):
        nonlocal answer
        if idx == len(numbers):
            if cur == target:
                answer += 1
            return
        dfs(idx + 1, cur + numbers[idx])
        dfs(idx + 1, cur - numbers[idx])

    dfs(0, 0)
    return answer
```
- 재귀함수를 호출하여, 현재 값에 더한 경우/뺀 경우 양쪽으로 가지치기를 한다.
- 마지막 인덱스에서 값이 같은 지를 판단하여 같으면 answer를 증가시킨다.

---
