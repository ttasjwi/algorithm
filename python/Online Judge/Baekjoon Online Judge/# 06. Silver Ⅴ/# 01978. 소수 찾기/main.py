import sys

input = lambda: sys.stdin.readline().rstrip()
n = int(input())
numbers = list(map(int, input().split()))
max_number = max(numbers)

is_composite_number = [False for i in range(max_number+1)]
is_composite_number[1] = True

for i in range(2, max_number + 1):
    if not is_composite_number[i]:
        for j in range(2 * i, max_number + 1, i):
            is_composite_number[j] = True

answer = 0
for number in numbers:
    if not is_composite_number[number]:
        answer += 1


print(answer, end='')
