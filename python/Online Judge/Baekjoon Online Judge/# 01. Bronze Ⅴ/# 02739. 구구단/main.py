n = int(input())
results = [f'{n} * {i} = {n * i}'
           for i in range(1, 10)
           ]
print(*results, sep='\n', end='')
