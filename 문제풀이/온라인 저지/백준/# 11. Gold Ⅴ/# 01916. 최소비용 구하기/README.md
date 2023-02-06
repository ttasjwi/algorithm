# 문제
- 플랫폼 : 백준
- 번호 : 01916
- 제목 : 최소비용 구하기
- 난이도 : Gold 5
- 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1916" target="_blank">링크</a>

---

# 필요 알고리즘

다익스트라 알고리즘에 대한 이해가 필요하다.

## 우선순위 큐 다익스트라 : O(ElogE)
- 여기서 로그의 밑은 2이다.
- 매 순간 최소 비용이 갱신되어 최솟힙 갱신이 발생하면, ElogE
- 보통 E는 V^2보다 작으므로 O(ElogE) = O(ElogV^2) = O(2ElogV) = (ElogV) 로 보기도 하는데
아래의 일반 다익스트라와 연산횟수의 비교를 위해서 O(ElogE)로 계산할 것

## 일반 다익스트라 : O(V^2)
- V번에 걸쳐 매 순간 방문하지 않은 최소 노드 찾기 : V^2

## 조건 분석
- 정점 수 V = 1000
- 간선 수 E = 100000
- 빠른 다익스트라 -> O(ElogE) -> 1_660_964
- 일반 다익스트라 -> O(V^2) -> 1_000_000

---

# 풀이

## 풀이1 : 우선순위 큐
```python
import heapq
import sys

input = sys.stdin.readline
print = sys.stdout.write
inf = 100_000_000


def main():
    n = int(input())
    m = int(input())

    graph = [[] for _ in range(n + 1)]

    for _ in range(m):
        s, e, c = map(int, input().split())
        graph[s].append((e, c))
    start, end = map(int, input().split())

    dist = [inf] * (n + 1)
    dist[start] = 0
    q = [(0, start)]
    while q:
        cost, node = heapq.heappop(q)
        if node == end:
            break
        for v, w in graph[node]:
            alt = cost + w
            if dist[v] > alt:
                dist[v] = alt
                heapq.heappush(q, (alt, v))
    print(str(dist[end]))


if __name__ == '__main__':
    main()
```
- 우선순위 큐를 통해 비용이 가장 저렴한 노드를 찾아 최단거리를 갱신시킨다.
- 여기서는 heapq를 사용하여 우선순위 큐를 구현했다.
- 도착점을 꺼낸 시점에서는 비용을 갱신시키고, break 한다.
- 매번 힙에 삽입할 때마다 정렬이 발생하면 시간 비용이 발생한다. 모든 간선을 삽입하지말고 최소 비용일 때 삽입해야한다.

## 풀이2 : 기본 다익스트라
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
- 실제 백준 실행 속도는 이 풀이가 더 빠르게 측정된다.

---
