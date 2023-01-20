def solution(n, m):
    n, m = (m, n) if n < m else (n, m)
    gcd = get_gcd(n, m)
    return [gcd, n * m // gcd]


def get_gcd(n, m):
    r = n % m
    return m if r == 0 else get_gcd(m, r)

