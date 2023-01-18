from sys import stdin


def main():
    _, *nums = map(int, stdin.buffer.read().split())
    min_num, max_num = solution(nums)
    print(min_num, max_num, sep=' ', end='')


def solution(nums):
    return min(nums), max(nums)


main()
