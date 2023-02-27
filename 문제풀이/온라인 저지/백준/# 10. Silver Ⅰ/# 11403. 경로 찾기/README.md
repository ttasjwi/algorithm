# 문제
- 플랫폼 : 백준
- 번호 : 11403
- 제목 : 경로 찾기
- 난이도 : Silver 1
- 모든 정점 (i, j)에 대해서, i에서 j로 가는 경로가 있는지 없는지 구하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/11430" target="_blank">링크</a>

---

# 필요 알고리즘
- 플로이드 워셜
- DFS

---

# 풀이

## 풀이1: 플로이드 워셜
```python
import sys

src = sys.stdin
print = sys.stdout.write

n = int(src.readline())
con = [line.split() for line in src.read().splitlines()]

for m in range(n):
    for s in range(n):
        if con[s][m] == '0':
            continue
        for e in range(n):
            if con[m][e] == '0':
                continue
            con[s][e] = '1'

print('\n'.join(' '.join(line) for line in con))
```
- 플로이드 워셜 알고리즘을 응용하여, 연결상태만 확인함
- 시간 복잡도는 O(N^3)

## 풀이2: DFS
```python
import sys

src = sys.stdin
print = sys.stdout.write

n = int(src.readline())
con = [list(map(int, line.split())) for line in src.read().splitlines()]
graph = [[] for _ in range(n)]

for i in range(n):
    for j in range(n):
        if con[i][j]:
            graph[i].append(j)

s = []
answer = []
for i in range(n):
    check = ['0'] * n
    s.append(i)
    while s:
        j = s.pop()
        for k in graph[j]:
            if check[k] == '0':
                check[k] = '1'
                s.append(k)
    answer.append(' '.join(check))
print('\n'.join(answer))
```
- 주어진 인접 행렬을 인접 리스트로 변환한다.
- 각 행마다, i==j 인 지점을 스택에 삽입한다.
- 스택이 빌 때까지 다음을 반복한다.
  - 스택에서 요소를 꺼낸다.
  - 꺼낸 요소에서 갈 수 있는 인접한 곳들을 모두 방문처리 후 stack에 삽입한다.
- 각 열마다 방문배열 결과를 answer에 append

---
