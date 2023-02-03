import sys


def main():
    print = sys.stdout.write
    input = sys.stdin.readline

    n = int(input())
    counter = [0] * 8001

    max = -4001
    min = 4001
    sum = 0
    for _ in range(n):
        value = int(input())
        counter[value + 4000] += 1
        if value > max:
            max = value
        if value < min:
            min = value
        sum += value

    mode = -4001
    mode_count = 0
    mode_duplicated = False

    count = 0
    median = 4001
    for i in range(min + 4000, max + 4001):
        if counter[i]:
            count += counter[i]
            if median == 4001 and count >= n / 2:
                median = i - 4000
            if counter[i] > mode_count:
                mode = i - 4000
                mode_count = counter[i]
                mode_duplicated = False
            elif counter[i] == mode_count and not mode_duplicated:
                mode = i - 4000
                mode_duplicated = True

    avg = str(round(sum/n))
    median = str(median)
    mode = str(mode)
    scope = str(max-min)

    print('\n'.join([avg, median, mode, scope]))


if __name__ == '__main__':
    main()
