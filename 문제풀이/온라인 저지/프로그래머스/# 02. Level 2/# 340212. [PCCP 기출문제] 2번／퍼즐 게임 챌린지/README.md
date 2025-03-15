# 문제
- 플랫폼 : 프로그래머스
- 번호 : 340212
- 제목 : \[PCCP 기출문제\] 2번／퍼즐 게임 챌린지
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/340212" target="_blank">링크</a>

---

# 필요 지식
- 이분 탐색

---

# 풀이
```python
def solution(diffs, times, limit):
    lt = 1
    rt = max(diffs)
    answer = rt
    
    def is_over_limit(level):
        time = 0
        for i in range(len(diffs)):
            if diffs[i] <= level:
                time += times[i]
            else:
                time += (diffs[i] - level) * (times[i] + times[i - 1]) + times[i]
            
            if time > limit:
                return True
        return False
    
    while lt <= rt:
        level = (lt + rt) >> 1
        if is_over_limit(level):
            lt = level + 1
        else:
            answer = level
            rt = level - 1

    return answer
```
