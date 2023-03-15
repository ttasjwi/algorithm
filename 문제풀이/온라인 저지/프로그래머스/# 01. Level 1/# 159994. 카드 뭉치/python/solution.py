from typing import List


def solution(cards1: List[str], cards2: List[str], goal: List[str]):
    p1 = 0
    p2 = 0
    for word in goal:
        if p1 < len(cards1) and cards1[p1] == word:
            p1 += 1
        elif p2 < len(cards2) and cards2[p2] == word:
            p2 += 1
        else:
            return "No"
    return "Yes"
