from itertools import combinations
from collections import Counter

def solution(orders, course):
    result = []
    for r in course:

        # r 개 조합 문자열 -> 사전식 정렬 문자열을 -> counter 에 삽입 -> 가장 흔하게 등장한 순으로
        counter = Counter([''.join(sorted(tuple)) for order in orders for tuple in combinations(order, r)]).most_common()

        # 가장 많이 등장한 횟수가 1 이면 result 에 삽입 x
        if not counter or counter[0][1] == 1:
            continue

        # 등장횟수가 최댓값이 아닐 떄 중단하고, 최댓값인 동안 result에 계속 삽입
        for k, v in counter:
            if v != counter[0][1]:
                break
            result.append(k)

    # result 를 다시 사전순 정렬하여 반환
    return sorted(result)
