import sys

sys.setrecursionlimit(100000)

def solution(n):
    cache = [0] * (n + 1)
    cache[1] = 1
    return dp(n, cache)

def dp(x, cache):
    if x > 1 and not cache[x]:
        cache[x] = (dp(x-2, cache) + dp(x-1, cache)) % 1234567
    return cache[x]
