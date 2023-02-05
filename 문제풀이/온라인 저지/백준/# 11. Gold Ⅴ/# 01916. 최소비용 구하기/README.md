# 문제
- 플랫폼 : 백준
- 번호 : 01916
- 제목 : 최소비용 구하기
- 난이도 : Gold 5
- 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1916" target="_blank">링크</a>

---

# 필요 알고리즘
- 다익스트라 알고리즘

---

# 풀이

## 풀이1 : 우선순위 큐 사용
```python
import heapq
import sys

input = sys.stdin.readline
print = sys.stdout.write


def main():
    n = int(input())
    m = int(input())

    graph = [[] for _ in range(n + 1)]

    for _ in range(m):
        s, e, c = map(int, input().split())
        graph[s].append((e, c))

    start, end = map(int, input().split())

    q = [(0, start)]
    dist = [-1 for _ in range(n + 1)]
    while q:
        cost, node = heapq.heappop(q)
        if dist[node] == -1:
            dist[node] = cost
            if node == end:
                break
            for v, w in graph[node]:
                alt = cost + w
                heapq.heappush(q, (alt, v))
    print(str(dist[end]))


if __name__ == '__main__':
    main()
```
- 우선순위 큐를 통해 비용이 가장 저렴한 노드를 찾아 최단거리를 갱신시킨다.
- 여기서는 heapq를 사용하여 우선순위 큐를 구현했다.
- 도착점을 꺼낸 시점에서는 비용을 갱신시키고, break 한다.

## 풀이2 : 느린 다익스트라
```python
import sys

input = sys.stdin.readline
print = sys.stdout.write
inf = 100_000_000


def main():
    n = int(input())
    m = int(input())

    graph = [[] for _ in range(n + 1)]
    check = [False] * (n + 1)
    dist = [inf] * (n + 1)

    for _ in range(m):
        s, e, c = map(int, input().split())
        graph[s].append((e, c))

    start, end = map(int, input().split())

    dist[start] = 0
    for _ in range(n):
        min_cost = inf
        min_node = 0
        for i in range(1, n + 1):
            if not check[i] and (dist[i] < min_cost):
                min_cost = dist[i]
                min_node = i
        if min_node == end:
            break
        check[min_node] = True
        for e, c in graph[min_node]:
            if dist[min_node] + c < dist[e]:
                dist[e] = dist[min_node] + c
    print(str(dist[end]))


if __name__ == '__main__':
    main()
```
- 매 순간 방문하지 않은 최소비용 노드를 찾아서 방문처리후, 해당 노드 기준 인접한 노드들의 최소 비용 갱신
- 이론상 시간 복잡도는 이 쪽이 느린데(O(N^2)), 실제 백준 실행 속도는 이 풀이가 더 빠르게 측정된다.

---
