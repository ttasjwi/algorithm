def solution(lottos, win_nums):
    win_nums = set(win_nums)

    molu = 0
    win = 0

    for lotto in lottos:
        if lotto in win_nums:
            win += 1
        elif lotto == 0:
            molu += 1

    get_grade = lambda x: 7 - x if x >= 2 else 6
    return [get_grade(win + molu), get_grade(win)]

