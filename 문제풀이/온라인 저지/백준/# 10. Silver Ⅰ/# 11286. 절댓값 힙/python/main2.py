import heapq
import sys

src = sys.stdin.buffer
print = sys.stdout.write
src.readline()
commands = list(map(int, src.read().splitlines()))

plus_heap = []
minus_heap = []

for x in commands:
    if x > 0:
        heapq.heappush(plus_heap, x)
    elif x < 0:
        heapq.heappush(minus_heap, -x)
    else:
        if plus_heap and minus_heap:
            if plus_heap[0] >= minus_heap[0]:
                print(str(-heapq.heappop(minus_heap)) + '\n')
            else:
                print(str(heapq.heappop(plus_heap)) + '\n')
        elif plus_heap:
            print(str(heapq.heappop(plus_heap)) + '\n')
        elif minus_heap:
            print(str(- heapq.heappop(minus_heap)) + '\n')
        else:
            print('0\n')
