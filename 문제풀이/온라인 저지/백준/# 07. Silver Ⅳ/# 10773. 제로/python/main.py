import sys


def main():
    input = sys.stdin.readline

    stack = []
    for _ in range(int(input())):
        current = int(input())
        if current == 0:
            stack.pop()
        else:
            stack.append(current)
    print(sum(stack), end='')


if __name__ == '__main__':
    main()
