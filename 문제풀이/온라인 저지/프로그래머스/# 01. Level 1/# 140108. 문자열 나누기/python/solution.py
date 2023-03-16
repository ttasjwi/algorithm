def solution(s):
    lt = 0
    cnt = 0

    while lt < len(s):
        rt = lt + 1
        x = s[lt]
        same = 1
        diff = 0

        while rt < len(s) and same != diff:
            if s[rt] == x:
                same += 1
            else:
                diff += 1
            rt += 1

        lt = rt
        cnt += 1
    return cnt
