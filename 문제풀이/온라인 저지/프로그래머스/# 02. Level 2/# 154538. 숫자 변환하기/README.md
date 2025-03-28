# 문제
- 플랫폼 : 프로그래머스
- 번호 : 154538
- 제목 : 숫자 변환하기
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/154538" target="_blank">링크</a>

---

# 필요 지식
- BFS

---

# 풀이
```python
from collections import deque

def solution(x, y, n):
    if x == y:
        return 0

    check = [False] * (y + 1)
    funcs = [lambda x: x + n, lambda x: x * 2, lambda x: x * 3]
    check[x] = True
    answer = -1
    queue = deque([x])

    while queue:
        answer += 1
        for _ in range(len(queue)):
            cur_num = queue.popleft()

            for func in funcs:
                next_num = func(cur_num)
                if next_num == y:
                    return answer + 1
                elif next_num < y and not check[next_num]:
                    check[next_num] = True
                    queue.append(next_num)
    return -1
```
