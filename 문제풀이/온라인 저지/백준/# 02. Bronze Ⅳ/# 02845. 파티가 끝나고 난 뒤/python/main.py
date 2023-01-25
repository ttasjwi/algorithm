l, p = map(int, input().split())
total = l * p
answer = ' '.join(str(number - total) for number in map(int, input().split()))
print(answer, end='')
