# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012951
- 제목 : JadenCase 문자열 만들기
- 난이도 : Level 2
- 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12951" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

---

# 풀이
```python
def solution(s):
    result = []
    is_before_char_space = True
    for i in range(len(s)):
        if s[i].isspace():
            is_before_char_space = True
            result.append(s[i])
        else:
            if is_before_char_space:
                result.append(s[i].upper())
                is_before_char_space = False
            else:
                result.append(s[i].lower())
    return ''.join(result)
```
- 현재 문자가 공백이면 'is_before_char_space' 플래그를 True 로 하고, result 에 삽입
- 현재 문자가 공백이 아니면
  - 이전 문자가 공백이면, 대문자화해서 삽입 후 플래그를 False로 변경
  - 이전 문자가 공백이 아니면, 소문자화해서 삽입한다.

---
