import io, os, sys

print = sys.stdout.write

src = io.BytesIO(os.read(0, os.fstat(0).st_size))
lines = src.read().decode().rstrip().split(sep='\n')[1:]

answer = 0

for line in lines:
    chars = set()
    before = None
    is_group_word = True
    for ch in line:
        if before != ch:
            if ch in chars:
                is_group_word = False
                break
            chars.add(ch)
            before = ch
    if is_group_word:
        answer += 1

print(str(answer))
