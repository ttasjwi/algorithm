import io
import os

array = [[True if ch == 'W' else False for ch in line] for line in
         io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split(sep='\n')[1:]]

answer = 33
for i in range(0, len(array) - 7):
    for j in range(0, len(array[0]) - 7):
        start = array[i][j]
        is_wrong = not start
        count = 0
        for a in range(0, 8):
            for b in range(0, 8):
                if array[i + a][j + b] == is_wrong:
                    count += 1
                is_wrong = not is_wrong
            is_wrong = not is_wrong
        answer = min(answer, min(count, 64 - count))
print(answer, end='')
