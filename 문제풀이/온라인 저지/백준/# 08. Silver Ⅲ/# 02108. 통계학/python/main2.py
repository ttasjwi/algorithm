from collections import Counter
from sys import stdin, stdout


def main():
    print = stdout.write
    n = int(stdin.readline())
    c = Counter(range(-4000, 4001)) + Counter(map(int, stdin.read().split())) - Counter(range(-4000, 4001))
    elements = list(c.elements())
    mc = c.most_common(2)

    avg = str(round(sum(elements)/n))
    median = str(elements[n//2])
    mode = str(mc[0][0] if len(mc) == 1 or mc[0][1] > mc[1][1] else mc[1][0])
    scope = str(elements[-1] - elements[0])
    print('\n'.join([avg, median, mode, scope]))


if __name__ == '__main__':
    main()
