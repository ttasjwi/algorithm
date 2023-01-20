import sys


def main():
    numbers = range(input_int(), 0, -1)
    print('\n'.join(map(str, numbers)), end='')


def input_int():
    return int(sys.stdin.readline().rstrip())


main()
