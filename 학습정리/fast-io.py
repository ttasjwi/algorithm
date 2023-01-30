import io, os, sys

# 백준용 : read, readline, readlines
src = io.BytesIO(os.read(0, os.fstat(0).st_size))
# 로컬 테스트
src = open('input.txt', 'rb')

lines = src.read().decode().rstrip().split(sep='\n')

# 출력
print = sys.stdout.write
