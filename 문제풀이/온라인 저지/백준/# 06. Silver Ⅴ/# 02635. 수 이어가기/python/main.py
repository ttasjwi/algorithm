import sys

input = sys.stdin.readline
print = sys.stdout.write

n = int(input())
max_length = 0
max_length_nums = []
for y in range(1, n + 1):
    nums = [n]
    x = n
    while True:
        nums.append(y)
        z = x - y
        if z < 0:
            break
        x, y = y, z
    if len(nums) > max_length:
        max_length = len(nums)
        max_length_nums = nums

print(f'{max_length}\n{' '.join(map(str, max_length_nums))}')
