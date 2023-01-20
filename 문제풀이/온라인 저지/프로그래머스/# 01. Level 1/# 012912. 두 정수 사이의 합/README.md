# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012912
- 제목 : 두 정수 사이의 합
- 난이도 : Level 1
- a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12912" target="_blank">링크</a>

---

# 필요 지식
- 반복문
- 수학 - 등차수열의 합

---

# 풀이
## 풀이1 : 반복문
```python
def solution(a, b):
    a, b = (a, b) if (a <= b) else (b, a)
    return sum([i for i in range(a, b+1)])

```
- 작은 값, 큰 값을 비교한다.
- 작은 값부터 큰 값까지 쭈르륵 더한다.

## 풀이2 : 수학 - 등차수열의 합
```python
def solution(a, b):
    count = abs(b - a) + 1
    return (a + b) * count // 2
```
- 항의 갯수를 구한다.
- 양 끝값의 합과 항의 갯수를 곱하고 2로 나눈 것이 등차수열의 합이다.

---
