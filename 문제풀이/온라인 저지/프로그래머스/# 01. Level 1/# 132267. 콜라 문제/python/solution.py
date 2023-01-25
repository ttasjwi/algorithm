def solution(a, b, cola):
    answer = 0

    while cola >= a:
        cola, remainder = cola // a * b, cola % a
        answer += cola
        cola = cola + remainder

    return answer
