def solution(citations):
    citations.sort()
    l = len(citations)
    for i, citation in enumerate(citations):
        if citation >= l - i:
            return l - i
    return 0
