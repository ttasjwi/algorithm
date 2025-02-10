from math import sqrt

def solution(brown, yellow):
    sum = brown + yellow
    for y in range(3, int(sqrt(sum))+1):
        x, r = divmod(sum, y)
        if not r and (x-2) * (y-2) == yellow:
                return [x, y]
