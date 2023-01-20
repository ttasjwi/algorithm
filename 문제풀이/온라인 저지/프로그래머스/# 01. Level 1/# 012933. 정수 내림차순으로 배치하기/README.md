# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012933
- 제목 : 정수 내림차순으로 배치하기
- 난이도 : Level 1
- n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12933" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
def solution(n):
    return int(''.join(sorted(str(n), reverse=True)))
```
- 문자열화(str) -> 문자열
- 역순 정렬(sorted) -> 리스트
- ''로 join -> 문자열
- 정수화

---
