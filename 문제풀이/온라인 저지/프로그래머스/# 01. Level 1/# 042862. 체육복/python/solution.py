def solution(n, lost, reserve):
    lost, reserve = set(lost), set(reserve)
    lost, reserve = lost - reserve, reserve - lost
    answer = 0
    for i in range(1, n + 1):
        if i not in lost:
            answer += 1
        else:
            if not reserve:
                continue
            if i - 1 in reserve:
                reserve.remove(i - 1)
                answer += 1
            elif i + 1 in reserve:
                reserve.remove(i + 1)
                answer += 1
    return answer
