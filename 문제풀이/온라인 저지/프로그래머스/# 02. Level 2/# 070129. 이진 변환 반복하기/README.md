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
- 문자열 처리
- 구현

---

# 풀이
```python
def solution(s):
    # 변환 횟수 / 0 삭제 횟수
    result = [0, 0]

    while s != "1":
        c = 0
        for ch in s:
            if ch == '0':
                result[1] += 1
            else:
                c += 1
        s = bin(c)[2:]
        result[0] += 1
    return result
```
- while 문을 통해 루프를 돌리며 변환 작업을 한다.(x가 1이 아니게 될 때까지)
  - 문자를 하나하나 읽어가며 0이면 '0 삭제 횟수' 증가, 1이면 c 증가
  - c 값을 이진문자열로 변환 후, s 에 재할당 
  - '변환횟수' 증가
- 이렇게 구해진 '변환횟수'와 '0 삭제 횟수'를 배열에 담아 반환한다.

---
