import sys

input = sys.stdin.readline
print = sys.stdout.write
input()
switches = [0] + [True if ch == '1' else False for ch in input().split()]
for _ in range(int(input())):
    a, b = map(int, input().split())
    if a == 1:
        for i in range(b, len(switches), b):
            switches[i] = not switches[i]
    else:
        # 여자
        switches[b] = not switches[b]
        lt = b - 1
        rt = b + 1
        while 0 < lt and rt < len(switches):
            if switches[lt] == switches[rt]:
                switches[lt] = not switches[lt]
                switches[rt] = not switches[rt]
                lt -= 1
                rt += 1
            else:
                break

switches = ['1' if sw else '0' for sw in switches]

for i in range(1, len(switches)):
    print(switches[i])
    if i % 20 == 0:
        print('\n')
    else:
        print(' ')
