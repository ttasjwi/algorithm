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
