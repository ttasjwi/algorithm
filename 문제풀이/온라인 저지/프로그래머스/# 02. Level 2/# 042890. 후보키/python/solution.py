from itertools import combinations


def solution(relation):
    row_count = len(relation)
    col_count = len(relation[0])

    # combs : 가능한 모든 인덱스 조합
    combs = []

    # 칼럼 1개, 2개, ...
    for i in range(1, col_count + 1):
        # 칼럼 i 개의 조합 -> 각각 combs 에 append
        for comb in combinations(range(col_count), i):
            combs.append(comb)

    # 가능한 인덱스 조합 목록
    results = []

    def append_if_not_exist_subset(results, comb, tuples):
        # 유일성을 만족하는가?
        if len(tuples) != row_count:
            return

        # 최소성을 만족하는가? results 목록에 있는 인덱스 조합을 현재 인덱스 조합이 포함하고 있다면 최소성을 만족하지 않음.
        for result in results:
            if set(result).issubset(set(comb)):
                return
        results.append(comb)
        return

    for comb in combs:
        tuples = set(tuple([rel[idx] for idx in comb]) for rel in relation)
        append_if_not_exist_subset(results, comb, tuples)

    return len(results)
