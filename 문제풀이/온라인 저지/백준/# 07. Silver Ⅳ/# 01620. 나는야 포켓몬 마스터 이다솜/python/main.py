import sys

lines = sys.stdin.buffer.read().decode().splitlines()

n, m = map(int, lines[0].split())
dic = {word: str(idx + 1) for idx, word in enumerate(lines[1:n + 1])}
answer = '\n'.join(lines[int(line)] if line.isdigit() else dic[line] for line in lines[1 + n:])
print(answer)
