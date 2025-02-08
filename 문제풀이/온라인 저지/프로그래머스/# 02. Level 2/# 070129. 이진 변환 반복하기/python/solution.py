def solution(s):
    # 변환 횟수 / 0 삭제 횟수
    result = [0, 0]

    while s != "1":
        c = 0
        for ch in s:
            if ch == '0':
                result[1] += 1
            else:
                c += 1
        s = bin(c)[2:]
        result[0] += 1
    return result
