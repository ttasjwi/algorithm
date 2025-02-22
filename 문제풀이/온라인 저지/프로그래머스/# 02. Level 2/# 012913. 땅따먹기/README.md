# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012913
- 제목 : 땅따먹기
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12913" target="_blank">링크</a>

---

# 필요 지식
- DP

---

# 풀이
```python
def solution(land):
    dp = [[0 for _ in range(4)] for _ in range(len(land))]
    
    # 1등, 2등 점수/열
    first_score, first_col = 0, -1
    second_score, second_col = 0, -1

    for r in range(len(land)):
        # 이전 행에서의 1등, 2등 점수/열
        prev_first_score, prev_first_col = first_score, first_col
        prev_second_score, prev_second_col = second_score, second_col

        for c in range(4):
            # 이전 행의 1등 열과 열이 같으면 -> 이전 행 2등 점수 + 현재 칸 값
            # 이전 행의 1등 열과 열이 다르면 -> 이전 행 1등 점수 + 현재 칸 값
            dp[r][c] = prev_second_score + land[r][c] if c == prev_first_col else prev_first_score + land[r][c]
            
            # 1등 점수보다 같거나 많으면 1등 갱신
            if dp[r][c] >= first_score:
                second_score, second_col = first_score, first_col
                first_score, first_col = dp[r][c], c
            
            # 1등은 아닌데, 2등 점수보다 같거나 많으면 2등 갱신
            elif dp[r][c] >= second_score:
                second_score, second_col = dp[r][c], c
    # 최종 시점의 1등 점수를 반환
    return first_score
```
