# 문제
- 플랫폼 : 프로그래머스
- 번호 : 388353
- 제목 : 지게차와 크레인
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/388353" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```python
directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

def solution(storage, requests):
    storage = [list(s) for s in storage]
    answer = 0
    for request in requests:
        if len(request) == 1:
            remove_if_accessible(request, storage)
        else:
            remove_all(request[0], storage)

    for r in range(len(storage)):
        for c in range(len(storage[0])):
            if storage[r][c] not in ["#", '@']:
                answer += 1
    return answer


def remove_if_accessible(ch, storage):
    remove_list = []
    for r in range(len(storage)):
        for c in range(len(storage[0])):
            if storage[r][c] == ch and is_accessible(r,c, storage):
                remove_list.append((r,c))
    
    for r, c in remove_list:
        storage[r][c] = '#'
        link_side_to_accessible(r, c, storage) # 인접한 '@' 이 있다면, '#' 으로 변경



def remove_all(ch, storage):
    accessible_list = []
    for r in range(len(storage)):
        for c in range(len(storage[0])):
            if storage[r][c] == ch:
                if not is_accessible(r,c, storage):
                    storage[r][c] = '@'
                else:
                    accessible_list.append((r,c))

    for r, c in accessible_list:
        storage[r][c] = '#'
        link_side_to_accessible(r, c, storage) # 인접한 '@' 이 있다면, '#' 으로 변경

def is_accessible(r, c, storage):
    for dr, dc in directions:
        nr, nc = r + dr, c + dc  # 인접 좌표

        # 인접 좌표가 범위 밖일 경우 그 방향에서 접근 가능
        if not (0 <= nr < len(storage) and 0 <= nc < len(storage[0])):
            return True

        # 인접 좌표가 '#' 으로 마킹되어있으면 그곳으로 접근 가능
        if storage[nr][nc] == '#':
            return True

def link_side_to_accessible(r, c, storage):
    for dr, dc in directions:
        nr, nc = r + dr, c + dc

        # 인접한 곳이 '@'으로 마킹되어있다면 그 위치도 '#'으로 변경
        if 0 <= nr < len(storage) and 0 <= nc < len(storage[0]) and storage[nr][nc] == '@':
            storage[nr][nc] = '#'
            link_side_to_accessible(nr, nc, storage)
```
