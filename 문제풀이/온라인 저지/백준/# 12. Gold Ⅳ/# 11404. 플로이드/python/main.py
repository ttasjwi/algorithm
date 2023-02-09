import sys


def main():
    input = sys.stdin.readline
    print = sys.stdout.write

    n = int(input())
    m = int(input())
    inf = 1e10
    dis = [[0 if i == j else inf for j in range(n)] for i in range(n)]

    for _ in range(m):
        a, b, c = map(int, input().split())
        if dis[a - 1][b - 1] > c:
            dis[a - 1][b - 1] = c

    for m in range(n):
        for s in range(n):
            if s == m or dis[s][m] == inf:
                continue
            for e in range(n):
                if s == e or m == e:
                    continue
                alt = dis[s][m] + dis[m][e]
                if dis[s][e] > alt:
                    dis[s][e] = alt

    for line in dis:
        for k in line:
            if k == inf:
                print('0 ')
            else:
                print(str(k) + ' ')
        print('\n')


if __name__ == '__main__':
    main()
