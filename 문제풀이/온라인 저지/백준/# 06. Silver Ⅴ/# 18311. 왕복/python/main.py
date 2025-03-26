import sys

print = sys.stdout.write
input = sys.stdin.readline

n, k = map(int, input().split())
lengths = list(map(int, input().split()))

start = 0
answer = None
for i in range(len(lengths)):
    end = start + lengths[i]
    if k < end:
        answer = i + 1
        break
    start = end

if not answer:
    for i in range(len(lengths)-1, -1, -1):
        end = start + lengths[i]
        if k < end:
            answer = i + 1
            break
        start = end
print(str(answer))
