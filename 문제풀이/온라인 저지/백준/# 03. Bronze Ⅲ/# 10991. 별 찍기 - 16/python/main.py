n = int(input())
answer = '\n'.join(' '* (n-i) + '* '*i for i in range(1, n+1))
print(answer, end ='')
