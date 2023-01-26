import io, os, sys

lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()[1:]
print = sys.stdout.write

answer = '\n'.join(f'Case #{idx +1}: {sum(map(int, line.split()))}' for idx, line in enumerate(lines))
print(answer)
