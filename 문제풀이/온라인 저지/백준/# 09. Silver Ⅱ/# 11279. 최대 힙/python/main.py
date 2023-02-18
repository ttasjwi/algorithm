import heapq
import sys

src = sys.stdin.buffer
print = sys.stdout.write

src.readline()
q = []
[
    heapq.heappush(q, -k) if k else print(str(-heapq.heappop(q)) + '\n' if q else '0\n')
    for k in map(int, src.read().splitlines())
]
