import sys

src = sys.stdin.buffer


def main():
    src.readline()
    times = sorted([tuple(map(int, line.split())) for line in src.read().splitlines()], key=lambda x: (x[1], x[0]))

    prev_e = 0
    cnt = 0
    for s, e in times:
        if prev_e <= s:
            prev_e = e
            cnt += 1
    print(cnt)


main()
