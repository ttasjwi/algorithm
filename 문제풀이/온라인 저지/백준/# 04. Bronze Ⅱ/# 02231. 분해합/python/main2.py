str_n = input()
n = int(str_n)
min = max(0, n - len(str_n) * 9)

answer = 0
for i in range(min, n):
    if n - sum(map(int, str(i))) == i:
        answer = i
        break
print(answer, end='')
