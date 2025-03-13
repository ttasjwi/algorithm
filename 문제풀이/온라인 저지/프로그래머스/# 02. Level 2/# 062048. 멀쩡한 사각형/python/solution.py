def solution(w,h):
    return w * h -  (w + h - gcd(w, h))

def gcd(a, b):
    if b > a:
        a, b = b, a
    r = a%b
    return b if r == 0 else gcd(b, r)
