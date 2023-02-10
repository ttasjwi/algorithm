a, b, v = map(int, input().split())

answer, mod = divmod(v - b, a - b)
if mod: answer += 1
print(answer)
