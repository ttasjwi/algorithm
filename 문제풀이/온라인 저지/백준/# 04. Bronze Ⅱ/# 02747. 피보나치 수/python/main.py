n = int(input())
nums = [-1] * 46


def dp(x):
    if nums[x] >= 0:
        return nums[x]
    if x in [0, 1]:
        nums[x] = x
        return nums[x]
    nums[x] = dp(x - 2) + dp(x - 1)
    return nums[x]


print(dp(n))
