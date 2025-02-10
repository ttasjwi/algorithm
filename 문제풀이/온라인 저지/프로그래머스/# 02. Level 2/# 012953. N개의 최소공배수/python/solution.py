def solution(arr):
    answer = 1
    for num in arr:
        answer = lcm(answer, num)
    return answer

def lcm(a, b):
    return a * b // gcd(a, b)

def gcd(a, b):
    if a < b:
        a, b = b, a
    r = a%b
    return b if r == 0 else gcd(b, r)
