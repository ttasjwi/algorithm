import sys

print = sys.stdout.write
n, k = map(int, input().split())
items = [i for i in range(1, n + 1)]
answer = []

cursor = 0
print('<')
for _ in range(n):
    cursor += k - 1
    cursor = cursor % len(items)
    answer.append(str(items.pop(cursor)))
print(', '.join(answer))
print('>')
