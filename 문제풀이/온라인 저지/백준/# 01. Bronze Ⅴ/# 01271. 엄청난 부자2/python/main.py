n, m = map(int, input().split())
answers = [str(n // m), str(n % m)]
print('\n'.join(answers), end='')
