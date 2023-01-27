def solution(dartResult: str):
    results = split_to_results(dartResult)
    scores = [0]

    for idx in range(len(results)):
        before = scores[idx]
        before, current = calculate_score(before, results[idx])
        scores[idx] = before
        scores.append(current)

    answer = sum(scores[1:])
    return answer


# 분리
def split_to_results(dartResult):
    results = []
    lt = 0
    rt = 1

    while lt < rt < len(dartResult):
        while rt < len(dartResult) - 1 and not dartResult[rt + 1].isnumeric():
            rt += 1
        results.append(dartResult[lt:rt + 1])
        lt = rt + 1
        rt = lt + 1

    return results


# 점수화
def calculate_score(before, result):
    current = 10 if result[0:2] == '10' else int(result[0])

    if 'D' in result:
        current **= 2
    elif 'T' in result:
        current **= 3

    if '*' in result:
        before *= 2
        current *= 2
    elif '#' in result:
        current *= -1

    return before, current
