from math import sqrt, ceil, floor

nums = [k ** 2 for k in range(ceil(sqrt(int(input()))), floor(sqrt(int(input()))) + 1)]

if not nums:
    print('-1')
else:
    print(sum(nums))
    print(nums[0])
