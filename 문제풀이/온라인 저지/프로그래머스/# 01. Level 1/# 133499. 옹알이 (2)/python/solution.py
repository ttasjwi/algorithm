from typing import List


def solution(babbling: List[str]):
    answer = 0
    for i in range(len(babbling)):
        babbling[i] = babbling[i].replace("aya", "1").replace("ye", "2").replace("woo", "3").replace("ma", "4").rstrip()
        if check(babbling[i]):
            answer += 1
    return answer


def check(word):
    before = ''
    for ch in word:
        if ch == before or ch.isalpha():
            return False
        before = ch
    return True


