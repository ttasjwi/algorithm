input()
nums = list(map(int, input().split()))
cnt = 1
before = nums[0]
for i in range(1, len(nums)):
    if before < nums[i]:
        cnt += 1
        before = nums[i]
print(cnt, end='')
