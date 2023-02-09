from math import sqrt

nums = [k for k in range(int(input()), int(input()) + 1) if sqrt(k) == int(sqrt(k))]
if not nums:
    print('-1')
else:
    print(sum(nums))
    print(nums[0])
