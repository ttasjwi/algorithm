n = int(input())
answer = ['*' * i + ' ' * 2 * (n-i) + '*'*i for i in range(1, n+1)]
answer += answer[-2::-1]
answer = '\n'.join(answer)
print(answer, end='')
