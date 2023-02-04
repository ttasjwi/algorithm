n = int(input())
result = [1, 1]

for i in range(2, n):
    result.append(result[i-1] + result[i-2])
print(' '.join(map(str, result)), end='')
