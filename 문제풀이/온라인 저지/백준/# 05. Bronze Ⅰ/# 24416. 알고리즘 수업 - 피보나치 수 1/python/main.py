n = int(input())

first, second = 1, 1
for i in range(3, n + 1):
    first, second = second, first + second
print(second, n-2)
