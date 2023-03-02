import sys

input = sys.stdin.buffer.readline
print = sys.stdout.write


def solution(sh, sm, ss, eh, em, es):
    h, m, s = eh - sh, em - sm, es - ss
    if s < 0:
        m -= 1
        s += 60
    if m < 0:
        h -= 1
        m += 60
    print(f'{h} {m} {s}\n')


for _ in range(3):
    solution(*map(int, input().split()))
