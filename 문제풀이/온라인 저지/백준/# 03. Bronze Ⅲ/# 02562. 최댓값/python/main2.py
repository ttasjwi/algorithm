import io, os, sys

print = sys.stdout.write

numbers = list(map(int, io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()))

max_value = -1
max_pos = 0
for idx, value in enumerate(numbers):
    if value > max_value:
        max_value = value
        max_pos = idx + 1
answer = '\n'.join([str(max_value), str(max_pos)])
print(answer)
