import heapq
import sys

src = sys.stdin.buffer
print = sys.stdout.write

src.readline()
nums = list(map(int, src.read().splitlines()))

q = []
for num in nums:
    if num:
        heapq.heappush(q, num)
    else:
        if not q:
            print('0')
            print('\n')
        else:
            item = heapq.heappop(q)
            print(str(item))
            print('\n')
