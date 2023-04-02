import sys

src = sys.stdin.buffer
n = int(src.readline())


def get_score(a, b, c):
    if a == c:
        return 10000 + a * 1000
    elif a == b or b == c:
        return 1000 + b * 100
    else:
        return c * 100


print(max([get_score(*sorted(map(int, line.split()))) for line in src.read().splitlines()]))
