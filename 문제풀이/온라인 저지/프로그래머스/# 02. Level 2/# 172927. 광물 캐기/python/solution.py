def solution(picks, minerals):
    # 최소 피로도
    min_cost = 25 * 50 + 1

    costs = [{'diamond': 1, 'iron': 1, 'stone': 1}, {'diamond': 5, 'iron': 1, 'stone': 1},
             {'diamond': 25, 'iron': 5, 'stone': 1}]

    def dfs(picks, idx, cost):
        nonlocal min_cost

        ## 모두 채굴했거나, 모든 곡괭이를 다 썼을 경우 종료
        if idx >= len(minerals) or (picks[0] == 0 and picks[1] == 0 and picks[2] == 0):
            # 비용이 최소 비용보다 적을 경우 갱신
            if cost < min_cost:
                min_cost = cost
            return

        # 가진 곡괭이들을 확인
        for i in range(3):

            # 곡괭이를 쓸 수 있다면 확인
            if picks[i] > 0:
                cur = idx
                next_cost = cost
                count = 5
                while cur < len(minerals) and count > 0:
                    next_cost += costs[i][minerals[cur]]
                    cur += 1
                    count -= 1

                # 그렇게 누적한 비용이 최소 비용보다 적으면 더 탐색할 가치가 있으므로 탐색
                # 최소 비용 이상일 경우, 더 탐색할 가치가 없으므로 종료
                if next_cost < min_cost:
                    dfs([picks[i] - 1 if i == j else picks[j] for j in range(3)], cur, next_cost)

    dfs(picks[:], 0, 0)
    return min_cost
