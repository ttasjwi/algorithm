import io, os

_, *numbers = map(int, io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().split())

min_value = 1_000_000
max_value = -1_000_000
for value in numbers:
    if value < min_value:
        min_value = value
    if value > max_value:
        max_value = value

answer = ' '.join([str(min_value), str(max_value)])
print(answer)
