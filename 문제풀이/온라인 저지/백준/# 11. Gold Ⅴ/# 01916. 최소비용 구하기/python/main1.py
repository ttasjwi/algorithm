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
