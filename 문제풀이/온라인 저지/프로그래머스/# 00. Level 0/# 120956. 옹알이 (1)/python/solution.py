from typing import List


def solution(babbling: List[str]):
    return sum(1
               for word in babbling
               if word.replace("aya", " ").replace("ye", " ").replace("woo", " ").replace("ma", " ").isspace())
