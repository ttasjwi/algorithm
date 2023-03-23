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
def solution(s: str):
    chars = list(s)

    for i, ch in enumerate(chars):
        if i - 1 == -1 or chars[i - 1] == ' ':
            chars[i] = ch.upper()
        else:
            chars[i] = ch.lower()

    return ''.join(chars)
```
- 이전 인덱스의 번호가 -1이거나, 이전 인덱스의 문자가 공백문자이면 대문자화한다.
- 그 외의 경우에 대해서는 모두 소문자화한다.
