# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012932
- 제목 : 자연수 뒤집어 배열로 만들기
- 난이도 : Level 1
- 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/12932)

---

# 필요 지식
- 리스트 컴프리헨션
- 문자열/리스트 슬라이싱

---

# 풀이
```python
def solution(n):
    return [int(ch) for ch in str(n)][::-1]
```
- 문자열화 시킨 후 뒤집기
- int 배열로 변환
- 뒤집기 (리스트 슬라이싱)

---
