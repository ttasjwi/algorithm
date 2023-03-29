import sys

src = sys.stdin

src.readline()
dic = {chr(x): 0 for x in range(97, 123)}

for line in src.read().splitlines():
    dic[line[0]] += 1
answer = [k for k, v in dic.items() if v >= 5]
print('PREDAJA' if not answer else ''.join(answer))
