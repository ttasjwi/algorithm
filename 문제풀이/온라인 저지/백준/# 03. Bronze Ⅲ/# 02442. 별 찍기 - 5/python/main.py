n = int(input())
answer = '\n'.join(' ' * (n - i) + '*' * (2 * i - 1) for i in range(1, n + 1))
print(answer, end='')
