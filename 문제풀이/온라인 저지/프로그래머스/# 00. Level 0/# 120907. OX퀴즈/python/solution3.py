from typing import List


def solution(quiz: List[str]):
    return ["O" if eval(q.replace('=', '==')) else 'X' for q in quiz]
