# 문제
- 플랫폼 : 프로그래머스
- 번호 : 070129
- 제목 : 이진 변환 반복하기
- 난이도 : Level 2
- 0과 1로 이루어진 문자열 s가 매개변수로 주어지고  s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때,
이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/70129" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```python
zero = 0
convert_cnt = 0


def solution(s):
    while s != "1":
        s = convert(s)
    return [convert_cnt, zero]


def convert(x):
    global zero, convert_cnt
    cnt = 0
    for ch in x:
        if ch == '0':
            zero += 1
        else:
            cnt += 1
    convert_cnt += 1
    return bin(cnt)[2:]

```
- 문자를 순차적으로 읽어가면서 '0'의 갯수를 누적 카운팅
- 매 순간 문자열에서 '0'이 아닌 것들의 갯수를 구하고 이 갯수를 이진 문자열로 변환한다.
- 최종적으로 변환횟수와 '0' 갯수 반환

---
