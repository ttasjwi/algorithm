import io, os, sys
from math import sqrt

print = sys.stdout.write
lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split(sep='\n')[1:]


def main():
    answer = '\n'.join(str(calculate(line)) for line in lines)
    print(answer)


def calculate(line: str):
    x1, y1, r1, x2, y2, r2 = map(int, line.split())
    d = sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)

    # 같은 원
    if d == 0 and r1 == r2:
        return -1

    # 외접, 내접
    if r1 + r2 == d or abs(r1 - r2) == d:
        return 1

    # 두 점에서 만난다
    if abs(r1 - r2) < d < r1 + r2:
        return 2

    # 만나지 않는 두 원
    else:
        return 0


if __name__ == '__main__':
    main()
