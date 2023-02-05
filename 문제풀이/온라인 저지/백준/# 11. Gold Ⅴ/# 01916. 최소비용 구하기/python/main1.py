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
