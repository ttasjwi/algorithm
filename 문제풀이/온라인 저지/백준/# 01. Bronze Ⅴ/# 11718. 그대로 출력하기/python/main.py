import io, os, sys

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).read
print = sys.stdout.write

answer = input().decode()
print(answer)
