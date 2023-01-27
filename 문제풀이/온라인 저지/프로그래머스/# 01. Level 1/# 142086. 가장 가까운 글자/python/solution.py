
def solution(s):
    cache = {}
    results = []

    for i in range(0, len(s)):
        if s[i] not in cache:
            results.append(-1)
        else:
            results.append(i-cache[s[i]])
        cache[s[i]] = i
    return results
