import io, os, sys

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
# inputs = io.BytesIO(os.read(0, os.fstat(0).st_size))

print = sys.stdout.write
