import sys
from math import sqrt

n = 0

while True:
    a, b, c = map(int, sys.stdin.readline().split())
    if a == b == c == 0:
        break
    n += 1
    if c == -1:
        x = 'c'
        vv = a ** 2 + b ** 2
    elif a == -1:
        x = 'a'
        vv = c ** 2 - b ** 2
    else:
        x = 'b'
        vv = c ** 2 - a ** 2

    print(f"Triangle #{n}")
    if vv <= 0:
        print("Impossible.\n")
    else:
        print(f"{x} = {sqrt(vv):.3f}\n")
