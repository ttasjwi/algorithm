# 문제
- 플랫폼 : 프로그래머스
- 번호 : 068935
- 제목 : 3진법 뒤집기
- 난이도 : Level 1
- n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/68935" target="_blank">링크</a>

---

# 필요 지식
- 나머지 연산
- 진법 변환

---

# 풀이1
```python
def solution(n: int):
    nums = []
    while n > 0:
        nums.append(n % 3)
        n //= 3

    return sum(value * (3 ** idx) for idx, value in enumerate(nums[::-1]))
```
- nums 배열에 3으로 나눈 나머지를 순서대로 저장한다.
  - 예) `45 => [0, 0, 2, 1]`
  - 이때 인덱스 순서대로 3**0 자리, 3**1자리, 3**2자리, 3**3 자리이다.
- 이를 뒤집어야한다. `nums[::-1]`를 사용한다.
  - 예) `[0,0,2,1]` -> `[1, 2, 0, 0]`
- 순서대로 접근하여 값과 `3**index`를 곱한다.

# 풀이2
```python
def solution(n: int):
    string = ''
    while n > 0:
        string += str(n % 3)
        n //= 3

    return int(string, 3)
```
- 위와 방식은 비슷한데, 문자열화시켜서 그대로 string에 저장하면 바로 뒤집힌 삼진수를 구할 수 있다.
- int 함수를 이용해 진수를 지정하면 문자열을 해당 진법으로 해석하여 십진수를 반환한다.

---
