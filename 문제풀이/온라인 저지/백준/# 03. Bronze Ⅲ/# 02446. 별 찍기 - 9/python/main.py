n = int(input())
answer = [' ' * i + '*' * (2 * (n - i) - 1) for i in range(n)]
answer += answer[-2::-1]
answer = '\n'.join(answer)
print(answer, end='')
