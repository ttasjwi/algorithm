def solution(t: str, p: str):
    p_value, p_length = int(p), len(p)

    answer = 0
    for i in range(0, len(t) - p_length + 1):
        if int(t[i:i+p_length]) <= p_value:
            answer += 1

    return answer
