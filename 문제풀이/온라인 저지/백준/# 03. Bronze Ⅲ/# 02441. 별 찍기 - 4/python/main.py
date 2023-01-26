n = int(input())
answer = '\n'.join(' ' * i + '*' * (n-i) for i in range(n))
print(answer, end='')
