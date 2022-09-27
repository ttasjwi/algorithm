a = int(input())
b = int(input())

b_each = list(map(int, str(b)))

result1 = a * b_each[-1]
result2 = a * b_each[-2]
result3 = a * b_each[-3]
result4 = a * b
print(result1, result2, result3, result4, sep='\n', end='')
