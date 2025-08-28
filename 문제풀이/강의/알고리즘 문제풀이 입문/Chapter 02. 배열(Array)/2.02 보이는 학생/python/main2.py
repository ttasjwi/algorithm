n = int(input())
nums = list(map(int, input().split()))
answer = 1
lt = 0
rt = 1

while rt < len(nums):
    if nums[lt] < nums[rt]:
        lt = rt
        rt = lt + 1
        answer += 1
    else:
        rt += 1
print(answer)
