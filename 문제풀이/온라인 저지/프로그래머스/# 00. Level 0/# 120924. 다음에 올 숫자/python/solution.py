def solution(common):
    d = common[1] - common[0]

    # 등차 판별
    if d == common[2] - common[1]:
        return common[-1] + d

    # 등비
    if common[0] == 0:
        return 0

    return common[-1] * (common[1]//common[0])
