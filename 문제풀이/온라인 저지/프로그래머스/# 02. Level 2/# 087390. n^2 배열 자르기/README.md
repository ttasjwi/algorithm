# 문제
- 플랫폼 : 프로그래머스
- 번호 : 076502
- 제목 : n^2 배열 자르기
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/76502" target="_blank">링크</a>

---

# 필요 지식
- 배열
- 구현

---

# 풀이
```python
def solution(n, left, right):
    result = []
    for i in range(left, right+1):
        r, c = divmod(i, n)
        result.append(r + 1 if r >= c else c + 1)
    return result
```
- left..right 사이의 인덱스를 i 이라 할 때
- 원본 이차원 배열에서의 행(r), 열(c)은 i/n, i%n이다. (행-열의 인덱스를 0,1,2... n-1로 환산했을 때)
- answer[i]는
  - 행>=열 일 때는 r+1 이고
  - 행<열 일 때는 c+1 이다.

---
