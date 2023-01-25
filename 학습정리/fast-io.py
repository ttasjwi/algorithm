import io, os, sys

# 라인울 문자열로
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

# 라인들을 리스트로
input_lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines

# 모든 문자열 통채로(decode 필요)
input_all = io.BytesIO(os.read(0, os.fstat(0).st_size)).read

# 출력
print = sys.stdout.write
