# 문제
- 플랫폼 : 프로그래머스
- 번호 : 148653
- 제목 : 마법의 엘리베이터
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/148653" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘
- 구현

---

# 풀이
```python
def solution(storey):
    answer = 0

    while storey > 0:
        storey, r = divmod(storey, 10)
        
        # 뒷자리가 5보다 크면 올라가는게 이득 (예: 7 -> 10 -> 0)
        # 뒷자리가 5면서 뒷 앞자리가 5,6,7,8,9 인 경우 올라가는게 이득 (5는 사실 올라가나 내려가나 같음)
        # 55 -> 50 -> 0 (10)
        # 55 -> 60 -> 100 -> 0 (10)
        # 75 -> 80 -> 100 -> 0 (8)
        if r > 5 or  (r == 5 and storey % 10 >= 5):
            answer += 10 - r
            storey += 1

        # 뒷자리가 5보다 작으면 내려가는게 이득 (예: 4 -> 0)
        
        # 뒷자리가 5이면서 뒷앞자리가 0,1,2,3,4 인 경우 내려가는게 이득
        # 35 -> 40 -> 0 (9)
        # 35 -> 30 -> 0 (8)
        
        # 45 -> 50 -> 0 (10)
        # 45 -> 40 -> 0 (9)
        else:
            answer += r
    return answer
```
