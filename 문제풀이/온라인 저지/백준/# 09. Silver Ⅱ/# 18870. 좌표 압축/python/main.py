import sys

input = sys.stdin.readline

n = int(input())
nums = [*map(int, input().split())]
ranks = {num: idx for idx, num in enumerate(sorted(set(nums)))}
answer = ' '.join(str(ranks[num]) for num in nums)
print(answer)
