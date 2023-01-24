n = int(input())
answer = '\n'.join(f'{n} * {i} = {n * i}' for i in range(1, 9+1))
print(answer)
