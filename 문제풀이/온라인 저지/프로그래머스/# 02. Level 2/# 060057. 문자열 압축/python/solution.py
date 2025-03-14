def solution(s):
    answer = len(s)
    for unit in range(1, len(s) // 2 + 1):
        lt = 0
        rt = unit
        arr = []
        while rt <= len(s):
            pattern = s[lt:rt]
            count = 0
            while rt <= len(s) and pattern == s[lt:rt]:
                count += 1
                lt += unit
                rt += unit
            if count >= 2:
                arr.append(str(count))
            arr.append(pattern)
        if lt < len(s):
            arr.append(s[lt:])
        length = len(''.join(arr))
        if length < answer:
            answer = length
    return answer
