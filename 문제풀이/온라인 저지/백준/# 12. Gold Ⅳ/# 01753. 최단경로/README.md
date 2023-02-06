# 문제
- 플랫폼 : 백준
- 번호 : 01753
- 제목 : 최단경로
- 난이도 : Gold 4
- 방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/1753" target="_blank">링크</a>

---

# 필요 지식
다익스트라 알고리즘

## 조건 읽기
- 정점 수 V = 20000
- 간선 수 E = 300000
- 일반 다익스트라 -> O(V^2) -> 400_000_000
- 우선순위 큐 다익스트라 -> O(ElogE) -> 5_458_380
- 우선순위 큐 다익스트라가 압도적으로 빠르고, 이 경우 일반 다익스트라로 시간 초과가 발생할 것 같다.

---

# 풀이

## 풀이
```python
import heapq
import sys

input = sys.stdin.readline
print = sys.stdout.write
inf = 200000


def main():
    v, e = map(int, input().split())
    start = int(input())

    graph = [[] for _ in range(v + 1)]

    for _ in range(e):
        a, b, c = map(int, input().split())
        graph[a].append((b, c))

    dist = [inf] * (v + 1)
    dist[start] = 0
    q = [(0, start)]
    while q:
        cost, node = heapq.heappop(q)
        if dist[node] < cost:
            continue
        for n, c in graph[node]:
            alt = cost + c
            if dist[n] > alt:
                dist[n] = alt
                heapq.heappush(q, (alt, n))
    answer = '\n'.join('INF' if d == inf else str(d) for d in dist[1:])
    print(answer)


if __name__ == '__main__':
    main()
```
- 모든 정점까지 비용을 inf로 초기화
- heapq를 이용해 우선순위 큐 다익스트라를 구현한다.
- 큐에 시작 간선을 삽입하고, dist 갱신
- 큐에 데이터 삽입으로 인한 최소힙 갱신을 최소화하기 위해, 매 순간 비용을 비교하고 더 저렴할 때만 삽입한다.

---
