n, k = map(int, input().split())
temperatures = [0] + list(map(int, input().split()))

total = sum(temperatures[1:k + 1])
max = total

for i in range(k + 1, n+1):
    total = total - temperatures[i - k] + temperatures[i]
    if total > max:
        max = total
print(max)
