import io, os

_, *numbers = map(int, io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().split())

min_value, max_value = min(numbers), max(numbers)
answer = ' '.join([str(min_value), str(max_value)])
print(answer, end='')
