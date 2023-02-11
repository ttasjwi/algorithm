import sys

src = sys.stdin.buffer


def main():
    _, m = map(int, src.readline().split())
    nums = sorted(set(int(x) for x in src.read().splitlines()))
    print(solution(nums, m))


def solution(nums, m):
    answer = nums[-1] - nums[0]
    for i in range(len(nums)):
        for j in range(i, len(nums)):
            diff = nums[j] - nums[i]
            if diff == m:
                return m
            elif diff > m:
                if answer > diff:
                    answer = diff
    return answer

main()
