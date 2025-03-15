def solution(diffs, times, limit):
    lt = 1
    rt = max(diffs)
    answer = rt

    def is_over_limit(level):
        time = 0
        for i in range(len(diffs)):
            if diffs[i] <= level:
                time += times[i]
            else:
                time += (diffs[i] - level) * (times[i] + times[i - 1]) + times[i]

            if time > limit:
                return True
        return False

    while lt <= rt:
        level = (lt + rt) >> 1
        if is_over_limit(level):
            lt = level + 1
        else:
            answer = level
            rt = level - 1

    return answer
