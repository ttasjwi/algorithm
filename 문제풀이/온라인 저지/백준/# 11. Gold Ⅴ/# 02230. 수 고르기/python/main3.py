import sys

src = sys.stdin.buffer


def main():
    _, m = map(int, src.readline().split())
    nums = sorted(set(int(x) for x in src.read().splitlines()))
    print(solution(nums, m))


def solution(nums, m):
    answer = nums[-1] - nums[0]
    lt = 0
    rt = 0

    while rt < len(nums):
        diff = nums[rt] - nums[lt]
        if diff == m:
            return m
        elif diff > m:
            if answer > diff:
                answer = diff
            lt += 1
        else:
            rt += 1
    return answer


main()
