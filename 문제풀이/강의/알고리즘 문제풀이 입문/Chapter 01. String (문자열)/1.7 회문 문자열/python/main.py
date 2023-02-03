s = input().lower()
answer = 'YES' if s == s[::-1] else 'NO'
print(answer, end='')
