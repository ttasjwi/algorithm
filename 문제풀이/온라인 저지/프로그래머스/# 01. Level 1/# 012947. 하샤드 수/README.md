# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012947
- 제목 : 하샤드 수
- 난이도 : Level 1
- x의 자릿수의 합으로 x가 나누어 떨어지는 지 판별
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12947" target="_blank">링크</a>

---

# 필요 지식
- 나머지 연산
- 문자열 처리

---

# 풀이

## 풀이1 : 나머지 연산
```python
def solution(x):
    n = x
    total = 0

    while n > 0:
        total += n%10
        n //= 10

    return x%total == 0

```

## 풀이2 : 문자열 처리
```python
def solution(x):
    return x % sum([int(i) for i in str(x)]) == 0
```

---
