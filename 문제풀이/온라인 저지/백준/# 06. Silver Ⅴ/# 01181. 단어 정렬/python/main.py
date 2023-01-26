import io, os, sys

answer = '\n'.join(
    sorted(set(io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().strip().split('\n')[1:]),
           key=lambda x: (len(x), x)))
sys.stdout.write(answer)
