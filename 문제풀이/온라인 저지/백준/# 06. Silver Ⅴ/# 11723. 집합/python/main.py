import sys

input = sys.stdin.readline
print = sys.stdout.write

m = int(input())
s = set()
nums = set(str(i) for i in range(1, 21))
for _ in range(m):
    line = input().split()
    if line[0] == "add":
        s.add(line[1])
    elif line[0] == "remove":
        if line[1] in s:
            s.remove(line[1])
    elif line[0] == "check":
        print('1' if line[1] in s else '0')
        print('\n')
    elif line[0] == "toggle":
        if line[1] in s:
            s.remove(line[1])
        else:
            s.add(line[1])
    elif line[0] == 'all':
        s = nums.copy()
    elif line[0] == 'empty':
        s.clear()
