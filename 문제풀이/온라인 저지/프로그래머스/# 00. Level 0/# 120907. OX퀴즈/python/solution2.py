from typing import List

RIGHT_MARK = 'O'
WRONG_MARK = 'X'


def solution(quiz: List[str]):
    return [RIGHT_MARK if is_right(q) else WRONG_MARK for q in quiz]


def is_right(q: str):
    x, oper, y, _, z = q.split(' ')
    return int(x) + get_sign(oper) * int(y) == int(z)


def get_sign(oper):
    return 1 if oper == '+' else -1
