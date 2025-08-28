# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 1.10
- 제목 : 가장 짧은 문자거리
- 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 차례로 출력

---

# 필요 지식
- 문자열 처리

---

# 풀이

## 풀이1  
```python
s, t = input().split()
dis = [101 for i in range(len(s))]

before = -1
for i in range(s.find(t), len(s)):
    if s[i] == t:
        dis[i] = 0
        for j in range(i - 1, before, -1):
            if dis[j] > dis[j + 1] + 1:
                dis[j] = dis[j + 1] + 1
            else:
                break
        before = i
    else:
        dis[i] = dis[i - 1] + 1
print(' '.join(map(str, dis)), end='')
```
- 발견하면 앞의 before까지 가면서 더이상 최소 거리 갱신이 되지 않을 때까지 갱신
- 이후엔 새로 발견할 때까지, 계속 기존 before로부터 거리 증가


## 풀이2 : 왼쪽 거리, 오른쪽 거리
```python
s, t = input().split()
dis = [0] * len(s)

lt_dis = 100
rt_dis = 100

for i in range(len(dis)):
    if s[i] == t:
        lt_dis = 0
    dis[i] = lt_dis
    lt_dis += 1
for i in range(len(dis) - 1, -1, -1):
    if s[i] == t:
        rt_dis = 0
    dis[i] = min(rt_dis, dis[i])
    rt_dis += 1
print(' '.join(map(str, dis)), end='')
```
- 왼쪽 방향에서 최소 거리 갱신
- 오른쪽 방향에서 최소 거리 갱신
- 결과 출력

## 풀이3: BFS
```python
from collections import deque

s, t = input().split()
costs = [100] * len(s)
q = deque()
for i, ch in enumerate(s):
    if ch == t:
        q.append(i)

cost = -1
while q:
    cost += 1
    size = len(q)
    for _ in range(size):
        i = q.popleft()
        if costs[i] <= cost:
            continue
        costs[i] = cost
        if i-1 >= 0:
            q.append(i-1)
        if i+1 < len(s):
            q.append(i+1)
print(*costs, end='')
```
- 우선 배열을 전부 순회해서, t 와 같은 문자의 인덱스를 큐에 삽입
- BFS 를 통해 각 지점의 최단거리를 갱신

---
