# 문제
- 플랫폼 : 프로그래머스
- 번호 : 068645
- 제목 : 삼각 달팽이
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/68645" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```python
def solution(n):
    # 최대 인덱스
    answer = [0] * (n * (n + 1) // 2)
    
    # 왼쪽 아래, 오른쪽, 왼쪽 위 반복 순회
    directions = [(1, 0), (0, 1), (-1, -1)]
    
    r = -1
    c = 0
    
    # 숫자의 최대값
    max_number = n * (n + 1) // 2
    # 현재 숫자
    number = 1

    while number <= max_number:
        
        # 방향배열을 순서대로 탐색
        for (dr, dc) in directions:
            while number <= max_number:
                nr, nc = r + dr, c + dc
                n_idx = get_idx(nr, nc)
                
                # 방향대로 따라갔을 때, 다음 위치의 인덱스에 값이 채워져 있지 않으면
                # 값을 채우고 방향 이동
                if (0 <= nr < n) and (0 <= nc <= nr) and answer[n_idx] == 0:
                    answer[n_idx] = number
                    number += 1
                    r, c = nr, nc
                
                # 갈 수 없는 위치이면 반복 멈추기
                else:
                    break
    
    return answer

# r,c 가 주어졌을 때 배열에서의 인덱스를 구하는 함수
def get_idx(r, c):
    return r * (r + 1) // 2 + c
```
