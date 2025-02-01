# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012925
- 제목 : 문자열을 정수로 바꾸기
- 난이도 : Level 1
- 문자열 s를 숫자로 변환한 결과를 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12925" target="_blank">링크</a>

---

# 필요 지식
- 문자열 파싱

---

# 풀이
### 풀이1: 내장함수 사용
```python
def solution(s: str):
    return int(s)
```
- 이미 잘 만들어진 바퀴가 있는데, 바퀴를 다시 발명할 필요가 없다.

### 풀이2: 문자열 파싱
```python
def solution(s):
    value = 0
    is_minus = False
    for ch in s:
        if ch == '+':
            pass
        elif ch == '-':
            is_minus = True
        else:
            value = value * 10 + (ord(ch) - 48)
    return -value if is_minus else value
```
- `+`로 시작하는 부분, `-`로 시작하는 부분을 읽어서 분기처리


---
