import io, os, sys

lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split(sep='\n')[1:]
answer = '\n'.join(line[0]+line[-1] for line in lines)
sys.stdout.write(answer)
