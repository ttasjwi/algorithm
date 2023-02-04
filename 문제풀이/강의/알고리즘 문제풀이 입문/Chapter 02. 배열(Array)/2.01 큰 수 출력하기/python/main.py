input()
nums = list(map(int, input().split()))
answer = [str(nums[0])]
for i in range(1, len(nums)):
    if nums[i - 1] < nums[i]:
        answer.append(str(nums[i]))
print(' '.join(answer), end='')

