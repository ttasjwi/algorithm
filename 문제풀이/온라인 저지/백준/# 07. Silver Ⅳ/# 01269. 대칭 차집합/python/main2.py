na, nb = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
print(2 * len(set(a+b)) - na - nb)
