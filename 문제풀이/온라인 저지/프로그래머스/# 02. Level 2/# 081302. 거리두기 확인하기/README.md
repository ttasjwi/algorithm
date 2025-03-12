# 문제
- 플랫폼 : 프로그래머스
- 번호 : 081302
- 제목 : 거리두기 확인하기
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/81302" target="_blank">링크</a>

---

# 필요 지식
- 구현
- 완전탐색(브루트 포스)

---

### 풀이
```python
w = 5
h = 5
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]  # 상하좌우
diagonal = [(-1, -1), (-1, 1), (1, -1), (1, 1)]  # 대각선 이동
long_moves = [(-2, 0), (2, 0), (0, -2), (0, 2)]  # 두 칸 이동

def solution(places):
    return [check_place(place) for place in places]

def check_place(place):
    for r in range(h):
        for c in range(w):
            if place[r][c] != 'P':
                continue

            # 상하좌우 검사
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if is_safe_index(nr, nc) and place[nr][nc] == 'P':
                    return 0

            # 두 칸 이동 검사 (중간에 파티션 확인)
            for dr, dc in long_moves:
                nr, nc = r + dr, c + dc
                mid_r, mid_c = r + dr // 2, c + dc // 2
                if is_safe_index(nr, nc) and place[nr][nc] == 'P' and place[mid_r][mid_c] != 'X':
                    return 0

            # 대각선 이동 검사 (양쪽 중 하나라도 파티션 없으면 실패)
            for dr, dc in diagonal:
                nr, nc = r + dr, c + dc
                if is_safe_index(nr, nc) and place[nr][nc] == 'P':
                    if place[r + dr][c] != 'X' or place[r][c + dc] != 'X':
                        return 0
    return 1

def is_safe_index(r, c):
    return 0 <= r < w and 0 <= c < h
```
- 문제에서 주어진 영역이 25칸밖에 없고, 5개의 대기실을 확인하므로, 전체를 탐색해도 무방하다.
- 시키는 대로 모든 영역을 다 테스트하면 되는 문제

---
