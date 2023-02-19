import heapq
import sys

src = sys.stdin.buffer
print = sys.stdout.write
src.readline()
commands = list(map(int, src.read().splitlines()))

q = []
for command in commands:
    if command == 0:
        if not q:
            print('0\n')
        else:
            _, value = heapq.heappop(q)
            print(str(value) + '\n')
    else:
        heapq.heappush(q, (abs(command), command))
