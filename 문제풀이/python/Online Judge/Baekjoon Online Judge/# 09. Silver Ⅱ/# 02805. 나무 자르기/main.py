import sys
from collections import Counter

n, m, *heights = map(int, sys.stdin.buffer.read().split())
heights = Counter(heights).items()
lt, rt = 0, max(heights)[0] - 1
answer = 0

while lt <= rt:
    mid = (lt + rt) // 2
    total = 0
    for height, count in heights:
        if height > mid:
            total += (height - mid) * count
    if total >= m:
        answer = mid
        lt = mid + 1
    else:
        rt = mid - 1
print(answer, end='')
