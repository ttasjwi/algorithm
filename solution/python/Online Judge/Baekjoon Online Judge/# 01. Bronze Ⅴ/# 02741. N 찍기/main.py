import sys


def main():
    numbers = range(1, input_int() + 1)
    print('\n'.join(map(str, numbers)), end='')


def input_int():
    return int(sys.stdin.readline().rstrip())


main()
