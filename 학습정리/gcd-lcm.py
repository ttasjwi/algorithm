# 최대 공약수 : Greatest Common Divisor, GCD
def gcd(a, b):
    if a <= b:
        a, b = b, a
    r = a % b
    return b if r == 0 else gcd(b, r)


# 최소 공배수 : Least Common Multiple, LCM
def lcm(a, b):
    return a * b // gcd(a, b)
