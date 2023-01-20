# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012940
- 제목 : 최대공약수와 최소공배수
- 난이도 : Level 1
- 두 수의 최대공약수와 최소공배수를 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12940" target="_blank">링크</a>

---

# 필요 지식
- gcd, lcm

---

# 풀이
```python
def solution(n, m):
    n, m = (m, n) if n < m else (n, m)
    gcd = get_gcd(n, m)
    return [gcd, n * m // gcd]


def get_gcd(n, m):
    r = n % m
    return m if r == 0 else get_gcd(m, r)

```

---

