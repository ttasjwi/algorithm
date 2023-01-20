import sys

_, *numbers, v = map(int, sys.stdin.buffer.read().split())
answer = 0
for number in numbers:
    if number == v:
        answer += 1
print(answer, end='')
