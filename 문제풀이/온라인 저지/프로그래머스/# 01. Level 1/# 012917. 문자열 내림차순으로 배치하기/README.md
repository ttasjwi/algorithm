# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012917
- 제목 : 문자열 내림차순으로 배치하기
- 난이도 : Level 1
- s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴(s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로
간주)
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12917" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
def solution(s:str):
    return ''.join(sorted(s, reverse=True))
```
- sorted로 내림차순 정렬 후, join

---
