import sys

src = sys.stdin.buffer


def main():
    _, m = map(int, src.readline().split())
    nums = sorted(set(int(x) for x in src.read().splitlines()))
    print(solution(nums, m))


def solution(nums, m):
    answer = nums[-1] - nums[0]
    for i in range(len(nums)):
        lt = i
        rt = len(nums) - 1
        while lt <= rt:
            mid = (lt + rt) // 2
            diff = nums[mid] - nums[i]
            if diff == m:
                return m
            elif diff > m:
                if answer > diff:
                    answer = diff
                rt = mid - 1
            else:
                lt = mid + 1
    return answer


main()
