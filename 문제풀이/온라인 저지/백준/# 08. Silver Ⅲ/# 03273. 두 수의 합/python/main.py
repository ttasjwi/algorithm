input()
arr = list(map(int, input().split()))
x = int(input())

nums = set()
cnt = 0
for num in arr:
    if x - num in nums:
        cnt += 1
    else:
        nums.add(num)
print(cnt)
