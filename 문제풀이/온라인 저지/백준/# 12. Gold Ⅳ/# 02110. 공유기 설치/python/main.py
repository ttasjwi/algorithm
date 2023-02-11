import sys


def solution():
    n, c, adr = input()
    return parametric_search(adr, c, n)


def input():
    src = sys.stdin.buffer
    n, c = map(int, src.readline().split())
    adr = [int(x) for x in src.read().splitlines()]
    adr.sort()
    return n, c, adr


def parametric_search(adr, c, n):
    answer = 0
    lt = 1
    rt = adr[-1] - adr[0]
    while lt <= rt:
        cnt = 1
        mid = (lt + rt) >> 1
        before = adr[0]
        for i in range(1, n):
            if cnt == c:
                break
            if adr[i] - before >= mid:
                before = adr[i]
                cnt += 1
        if cnt == c:
            answer = mid
            lt = mid + 1
        else:
            rt = mid - 1
    return answer


print(solution())
