n, m = map(int, input().split())
nums = sorted(list(map(int, input().split())))

lt = 0
rt = len(nums) - 1
mid = -1
while lt <= rt:
    mid = (lt + rt) >> 1
    if nums[mid] < m:
        lt = mid + 1
    elif nums[mid] > m:
        rt = mid - 1
    else:
        break
answer = mid + 1
print(answer, end = '')

