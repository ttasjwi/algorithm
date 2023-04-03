zero = 0
convert_cnt = 0


def solution(s):
    while s != "1":
        s = convert(s)
    return [convert_cnt, zero]


def convert(x):
    global zero, convert_cnt
    cnt = 0
    for ch in x:
        if ch == '0':
            zero += 1
        else:
            cnt += 1
    convert_cnt += 1
    return bin(cnt)[2:]

