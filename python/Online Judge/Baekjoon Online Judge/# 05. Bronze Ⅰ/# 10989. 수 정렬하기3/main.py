from sys import stdin, stdout

input = lambda: stdin.readline().rstrip()
print = stdout.write

n = int(input())
counter = [0] * 10_001

for _ in range(n):
    number = int(input())
    counter[number] += 1

for i in range(1, 10_001):
    if counter[i] > 0:
        while counter[i] > 1000:
            print((str(i) + '\n') * 1000)
            counter[i] -= 1000
        print((str(i) + '\n') * counter[i])
