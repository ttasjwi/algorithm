total = sum([int(input()) for _ in range(4)])
x, y = total//60, total%60
print(x, y, sep='\n')
