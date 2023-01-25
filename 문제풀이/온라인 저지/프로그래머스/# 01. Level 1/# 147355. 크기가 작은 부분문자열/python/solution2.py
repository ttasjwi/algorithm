def solution(t: str, p: str):
    p_length, p_value = len(p), int(p)
    return len([1 for i in range(0, len(t) - p_length + 1) if int(t[i:i + p_length]) <= p_value])

