# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012953
- 제목 : N개의 최소공배수
- 난이도 : Level 2
- n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12953" target="_blank">링크</a>

---

# 필요 지식
- 수학
- GCD, LCM

---

# 풀이
```python
def solution(arr):
    answer = 1
    for num in arr:
        answer = lcm(answer, num)
    return answer

def lcm(a, b):
    return a * b // gcd(a, b)

def gcd(a, b):
    if a < b:
        a, b = b, a
    r = a%b
    return b if r == 0 else gcd(b, r)
```
- N개의 최소공배수는 두개의 숫자의 최소공배수를 구하고, 그 다음 다른 수와 최소공배수 연산을 연쇄적으로 해서 구해도 된다.

---
__
