import sys

src = sys.stdin.buffer


def main():
    n, m, b = map(int, src.readline().split())
    counter = [0] * 257

    min_range = 257
    max_range = -1
    for line in src.read().rstrip().splitlines():
        for ch in line.split():
            value = int(ch)
            counter[value] += 1
            if min_range > value:
                min_range = value
            if max_range < value:
                max_range = value
    height = -1
    min_t = (max_range * n * m) * 2
    for standard in range(max_range, min_range - 1, -1):
        up = 0
        rm = 0
        for h in range(max_range, min_range - 1, -1):
            if not counter[h]:
                continue
            block = (standard - h) * counter[h]
            if block > 0:
                up += block
            elif block < 0:
                rm += -block
        if b + rm >= up:
            t = up + rm * 2
            if t < min_t:
                min_t = t
                height = standard
    print(min_t, height)


main()
