from collections import Counter


def solution(x, y):
    c = Counter(str(x)) & Counter(str(y))
    return '-1' if not c else '0' if len(c) == 1 and '0' in c else ''.join(sorted(c.elements(), reverse=True))
