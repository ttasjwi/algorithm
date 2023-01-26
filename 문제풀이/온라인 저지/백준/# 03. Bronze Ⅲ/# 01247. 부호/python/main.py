import io
import os
import sys

print = sys.stdout.write

numbers = map(int, io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines())
answer = [0] * 3

t_count = -1
count = 0
for n in numbers:
    if count == 0:
        count = n
        t_count += 1
    else:
        answer[t_count] += n
        count -= 1

answer = '\n'.join('+' if sum > 0 else '-' if sum < 0 else '0' for sum in answer)
print(answer)
