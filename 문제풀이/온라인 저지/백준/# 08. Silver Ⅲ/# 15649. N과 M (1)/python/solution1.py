import sys

print = sys.stdout.write
n, m = map(int, input().split())
nums = list(map(str, range(1, n + 1)))
check = [False] * n
result = []

arr = []

def back_tracking(depth):
    if depth == m:
        result.append(' '.join(arr))
        return
    for idx in range(n):
        if not check[idx]:
            check[idx] = True
            arr.append(nums[idx])
            back_tracking(depth + 1)
            arr.pop()
            check[idx] = False


back_tracking(0)
print('\n'.join(result))
