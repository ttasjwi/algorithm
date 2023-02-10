# 문제
- 플랫폼 : 백준
- 번호 : 01874
- 제목 : 스택 수열
- 난이도 : Silver 2
- 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있는데, 문제에서 주어진 스택 수열을 만들 수 있으면
push, pop 과정을 순서대로 출력하고 스택 수열을 만들 수 없으면 "NO" 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1874" target="_blank">링크</a>

---

# 필요 알고리즘
- 스택

---

# 풀이
```python
import sys


def solution():
    _, *nums = map(int, sys.stdin.buffer.read().splitlines())
    s = []
    answer = []
    cur = 1
    for value in nums:
        while cur <= value:
            answer.append('+')
            s.append(cur)
            cur += 1
        if s.pop() != value:
            return "NO"
        answer.append('-')
    return '\n'.join(answer)


print(solution())
```
- cur : 1,2,3, ... n 을 순서대로 가리키는 커서
- 다음을 반복한다.
  - cur가 value보다 작거나 같은 동안 계속 cur를 answer에 append하고 cur를 증가시킨다.
  - cur에서 마지막 요소를 꺼내고, 그 값이 value와 같지 않으면 순서가 올바르지 않다.
  - 올바르면 정상적으로 반복을 계속한다.
- 결과를 출력
