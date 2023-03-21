n = int(input())
a, b, c = map(int, input().split())
print(min(a, n) + min(n, b) + min(n, c))
