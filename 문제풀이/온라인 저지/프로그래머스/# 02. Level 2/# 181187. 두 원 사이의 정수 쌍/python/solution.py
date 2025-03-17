from math import sqrt

def solution(r1, r2):
    # 외부 원
    outer_count = 4 * r2 + 1
    for x in range(1, r2):
        outer_count += 4 * int(sqrt(r2 ** 2 - x ** 2))


    # 내부 원 : 경계는 제외해서 세야함
    inner_count = 4 * (r1 - 1) + 1
    for x in range(1, r1):
        y = sqrt(r1 ** 2 - x ** 2)
        int_y = int(y)

        if y == int_y:
            inner_count += 4 * max(int_y - 1, 0)
        else:
            inner_count += 4 * int_y

    # 외부원 점 갯수 - 내부원 점 갯수
    return outer_count - inner_count
