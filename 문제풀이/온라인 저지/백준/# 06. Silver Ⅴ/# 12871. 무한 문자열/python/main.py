def solution(s, t):
    lcm_len = lcm(len(s), len(t))
    return '1' if s * (lcm_len//len(s)) == t * (lcm_len//len(t)) else '0'

def gcd(a,b):
    if a <= b:
        a, b = b, a
    r = a % b
    return b if r == 0 else gcd(b, r)

def lcm(a, b):
    return a * b // gcd(a, b)

print(solution(input(), input()), end= '')
