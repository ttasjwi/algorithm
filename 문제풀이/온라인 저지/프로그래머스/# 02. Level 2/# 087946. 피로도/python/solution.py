# 풀이 : 재귀를 사용한 풀이
def solution(k, dungeons):
    answer = 0

    def backtracking(cur_k, cnt, visited):
        nonlocal answer
        dungeon_accessible = False # 다른 던전에 추가로 진입가능한 지 여부

        for i, (min_k, cost_k) in enumerate(dungeons):
            # 방문하지 않은 던전이고, 현재 피로도가 최소 피로도보다 많을 경우 던전 접근 가능
            if not visited[i] and cur_k >= min_k:

                # 다른 던전에 진입가능하므로
                if not dungeon_accessible:
                    dungeon_accessible = True
                visited[i] = True
                backtracking(cur_k - cost_k, cnt + 1, visited)
                visited[i] = False

        # 던전에 진입 불가능하면, 여태 진입한 던전 갯수를 answer 와 비교하여 최댓값 갱신
        if not dungeon_accessible and cnt >= answer:
            answer = cnt

    backtracking(k, 0, [False] * len(dungeons))
    return answer
