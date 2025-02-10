import sys

def solution(n):
    sys.setrecursionlimit(2000)

    cache = [0] * (n+1)
    cache[0] = 1
    cache[1] = 1
    return dp(n, cache)

def dp(x, cache):
    if not cache[x]:
        cache[x] = (dp(x-2, cache) + dp(x-1, cache)) % 1234567
    return cache[x]
