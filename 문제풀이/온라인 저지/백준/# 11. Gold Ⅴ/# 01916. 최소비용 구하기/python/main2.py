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
