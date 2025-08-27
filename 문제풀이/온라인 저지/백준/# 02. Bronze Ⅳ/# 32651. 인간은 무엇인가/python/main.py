memory = set()
x = 2024
while x <= 100000:
    memory.add(x)
    x += 2024

n = int(input())
print('Yes' if n in memory else 'No', end = '')
