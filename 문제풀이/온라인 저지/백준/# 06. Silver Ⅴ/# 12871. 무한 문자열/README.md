# 문제
- 플랫폼 : 백준
- 번호 : 12871
- 제목 : 무한 문자열
- 난이도 : Silver 5
- 두 수를 반복시켰을 때 서로 일치하는 지 여부 판단
- 문제 : <a href="https://www.acmicpc.net/problem/12871" target="_blank">링크</a>

---

# 필요 지식
- 수학
- 문자열

---

# 풀이
```python
s = input()
t = input()

def solution(s, t):
    len_lcm = lcm(len(s),len(t))

    s = s * (len_lcm // len(s))
    t = t * (len_lcm // len(t))
    return '0' if s!= t else '1'

def gcd(a, b):
    if a <= b:
        a, b = b, a
    r = a % b
    return b if r == 0 else gcd(b, r)

def lcm(a, b):
    return a * b // gcd(a, b)

print(solution(s, t), end='')
```
- 두 문자열의 길이가 다를 수 있으므로, 통일시키기 위해 최소공배수 길이가 되도록 문자열을 반복시킨다.
  - 이 최소공배수 구하는 과정이 귀찮은 점을 고려하면 그냥 반대쪽 문자열 길이 만큼 반복 문자열을 만들어서 통일시켜도 된다.
- 길이가 통일된 시점에, 문자열이 서로 같은지 판단하면 된다.

---
