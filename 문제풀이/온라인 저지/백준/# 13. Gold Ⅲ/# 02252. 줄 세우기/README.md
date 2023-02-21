# 문제
- 플랫폼 : 백준
- 번호 : 02252
- 제목 : 줄 세우기
- 난이도 : Gold 3
- 학생들을 앞에서부터 줄을 세운 결과를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2252" target="_blank">링크</a>

---

# 필요 지식
- 위상 정렬

---

# 풀이
```python
import sys

src = sys.stdin.buffer
n, _ = map(int, src.readline().split())
graph = [[] for _ in range(n + 1)]
in_degrees = [0] * (n + 1)

for line in src.read().splitlines():
    a, b = map(int, line.split())
    in_degrees[b] += 1
    graph[a].append(b)

s = []
answer = []
for i in range(1, n + 1):
    if not in_degrees[i]:
        s.append(i)
        answer.append(str(i))

while s:
    x = s.pop()
    for y in graph[x]:
        in_degrees[y] -= 1
        if not in_degrees[y]:
            s.append(y)
            answer.append(str(y))
sys.stdout.write(' '.join(answer))
```
- 비교 결과들을 기반으로 진입차수를 초기화하고, graph를 초기화한다.
- 진입차수가 0인 지점부터 스택에 삽입한다.
- 스택이 빌 때까지 스택의 요소를 꺼낸다.
  - answer에 꺼낸 요소를 추가한다. 
  - 스택에서 꺼낸 요소들에 대해 다음 요소들의 진입차수를 1씩 차감한다.
    - 진입차수가 0이면 스택에 삽입한다.
- answer를 출력한다.

---
