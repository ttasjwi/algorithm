import io, os, sys

print = sys.stdout.write

numbers = list(map(int, io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()))
max_value = max(numbers)
max_pos = numbers.index(max_value) + 1

answer = '\n'.join([str(max_value),str(max_pos)])
print(answer)
