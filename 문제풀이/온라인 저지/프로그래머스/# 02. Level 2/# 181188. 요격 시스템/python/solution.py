def solution(targets):
    answer = 0
    targets.sort(key=lambda x: (x[1], x[0])) # 종점 기준 오름차순으로 정렬

    prev_e = -1  # 마지막으로 요격한 미사일의 마지막 x 좌표

    for s, e in targets:
        # 기존 요격 미사일로 커버 가능할 때
        # ------
        #  ---

        # 요격 미사일이 새로 필요할 때 (1)
        # -----
        #     ----
        # 요격 미사일이 새로 필요할 떄 (2)
        # -----
        #        ------
        if s >= prev_e:
            answer += 1
            prev_e = e

    return answer
