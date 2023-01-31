def gcd(a, b):
    r = a % b
    return b if r == 0 else gcd(b, r)


a, b = map(int, input().split())
if a < b:
    a, b = b, a
gcd = gcd(a, b)
print('\n'.join((str(gcd), str(a * b // gcd))), end='')
