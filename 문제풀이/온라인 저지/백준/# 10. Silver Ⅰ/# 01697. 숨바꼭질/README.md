# 문제
- 플랫폼 : 백준
- 번호 : 01697
- 제목 : 숨바꼭질
- 난이도 : Silver 1
- 수빈이가 동생을 찾는 가장 빠른 시간을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1697" target="_blank">링크</a>

---

# 필요 지식
- BFS
- DP

---

# 풀이
## 풀이1: BFS
```python
from collections import deque

n, k = map(int, input().split())

funcs = [lambda x: x - 1, lambda x: x + 1, lambda x: 2 * x]


def bfs(n, k):
    if n == k:
        return 0
    q = deque()
    depth = -1
    check = [False] * 100001
    check[n] = True
    q.append(n)
    while q:
        depth += 1
        for _ in range(len(q)):
            x = q.popleft()
            for fun in funcs:
                y = fun(x)
                if 0 <= y <= 100000 and not check[y]:
                    if y == k:
                        return depth + 1
                    check[y] = True
                    q.append(y)


print(bfs(n, k))
```
- 시작 위치를 기준으로 bfs로 탐색하여 k까지 갈 수 있는 최대 depth를 찾는 방식

## 풀이2: DP
```python
dp = [-1] * 100001


def find(n, k):
    if dp[k] >= 0:
        return dp[k]
    if n >= k:
        dp[k] = n - k
        return dp[k]
    if k == 1:
        dp[k] = 1
        return dp[k]
    if k % 2:
        dp[k] = min(find(n, k - 1), find(n, k + 1)) + 1
        return dp[k]
    dp[k] = min(k - n, find(n, k // 2) + 1)
    return dp[k]


print(find(*map(int, input().split())))
```
- 거리를 계산하고 저장해가면서 재귀적으로 탐색하는 방식이다.
- n이 k보다 크거나 같으면 n에서 k에 갈 때는 1씩 빼면서 갈 수밖에 없으므로 바로 n-k를 반환한다.
- n이 k보다 작으면
  - k == 1 일 때 : 0에서 1로 가는 비용 (이 부분을 계산해두지 않으면 RecursionError가 발생한다.)
  - 그 외의 경우
    - k가 짝수 : 자기 앞에서 텔레포트 해온 경우, 걸어온 거리 중 최솟값이다.
    - k가 홀수 : 자기 앞에서 걸어서 경우, 그리고 자기 뒤에서 걸어서 온 경우 중에서 하나를 택하면 된다.

---
