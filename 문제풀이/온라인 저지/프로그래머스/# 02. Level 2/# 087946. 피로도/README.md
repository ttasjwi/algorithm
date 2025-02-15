# 문제
- 플랫폼 : 프로그래머스
- 번호 : 087946
- 제목 : 피로도
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/87946" target="_blank">링크</a>

---

# 필요 지식
- 백트래킹

---

# 풀이
```python
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
```
- 매 순간 여러개의 던전 중 하나를 선택해야하고, 현재 자신이 처한 조건에 따라 선택지가 달라진다.
- 이는 백트래킹으로 해석할 수 있다.
- 던전들 목록을 순회하면서, 방문하지 않았고 자신의 사용가능 피로도가 최소 요구 피로도보다 많을 경우 방문하기로 결정한다.
  - dungeon_accessable 변수는 다음 던전에 갈 수 없는 상태를 의미하는데 다음 던전에 갈 수 있으면 이 값을 True로 갱신한다.
  - 배열에서 해당 던전을 방문체크한다.
  - 방문체크를 해제한다.
- 던전 목록을 순회했을 때, 다른 던전에 갈 수 없는 상태면, answer 와 cnt 를 비교하여 최댓값을 갱신한다.
- 최종적으로 answer를 출력하면 된다.

---
