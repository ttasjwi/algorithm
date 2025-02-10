from math import sqrt

def solution(brown, yellow):
    # 가로(x) 기준으로 정리했을 때의 이차방정식 계수들
    a = 2
    b = - (brown + 4)
    c = 2 * (brown + yellow)

    # 판별식
    D = (b ** 2) - 4 * a * c

    # 근
    x = (- b + sqrt(D)) // (2 * a)
    y = (- b - sqrt(D)) // (2 * a)

    return [x, y]
