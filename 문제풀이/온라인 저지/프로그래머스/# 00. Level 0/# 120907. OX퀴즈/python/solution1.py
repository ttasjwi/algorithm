import re
from typing import List


def is_right(q):
    g = re.match(r'(-?\d+)\s([+-])\s(-?\d+)\s=\s(-?\d+)', q).groups()
    x, oper, y, z = int(g[0]), g[1], int(g[2]), int(g[3])
    return (x + y == z) if oper == '+' else (x - y == z)


def solution(quiz: List[str]):
    return ["O" if is_right(q) else 'X' for q in quiz]


