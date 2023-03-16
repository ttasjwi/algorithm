# 문제
- 플랫폼 : 프로그래머스
- 번호 : 140108
- 제목 : 문자열 나누기
- 난이도 : Level 1
- 분해한 문자열의 개수를 return 하는 함수 solution을 완성
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/140108 target="_blank">링크</a>

---

# 필요 지식
- 투 포인터

---

# 풀이
```python
def solution(s):
    lt = 0
    cnt = 0

    while lt < len(s):
        rt = lt + 1
        x = s[lt]
        same = 1
        diff = 0

        while rt < len(s) and same != diff:
            if s[rt] == x:
                same += 1
            else:
                diff += 1
            rt += 1

        lt = rt
        cnt += 1
    return cnt
```
- lt, rt 포인터 두 개를 사용해, 시작 문자를 기준으로 카운팅

---
