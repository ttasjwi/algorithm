import io, os, sys

print = sys.stdout.write
inputs = io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode()
print(inputs)
