import io, os, sys


def main():
    answer = []
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
    print = sys.stdout.write

    inf = 25_000_000

    def bf():
        for i in range(n):
            for s, e, t in edges:
                alt = dis[s] + t
                if dis[e] > alt:
                    if i == n - 1:
                        return 1
                    dis[e] = alt
        return 0

    for _ in range(int(input())):
        n, m, w = map(int, input().split())
        edges = []
        dis = [inf] * (n + 1)
        for _ in range(m):
            s, e, t = map(int, input().split())
            edges.append((s, e, t))
            edges.append((e, s, t))

        for _ in range(w):
            s, e, t = map(int, input().split())
            edges.append((s, e, -t))
        if bf():
            answer.append('YES')
        else:
            answer.append('NO')
    print('\n'.join(answer))


if __name__ == '__main__':
    main()
