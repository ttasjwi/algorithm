numbers = list(map(int, input().split()))
total = 0
for number in numbers:
    total += number ** 2
answer = total % 10
print(answer, end='')
