n = int(input())
nums = [int(x) for x in input().split()]
answer = []
for i, num in enumerate(nums):
    if i == 0 or nums[i - 1] < nums[i]:
        answer.append(str(num))
print(' '.join(answer), end = '')

