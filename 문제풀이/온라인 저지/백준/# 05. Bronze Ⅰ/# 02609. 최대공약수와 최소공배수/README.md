# 문제
- 플랫폼 : 백준
- 번호 : 02609
- 제목 : 최대공약수와 최소공배수
- 난이도 : Bronze 1
- 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2609" target="_blank">링크</a>

---

# 필요 알고리즘
- GCD, LCM

---

# 풀이
```python
def gcd(a, b):
    r = a % b
    return b if r == 0 else gcd(b, r)


a, b = map(int, input().split())
if a < b:
    a, b = b, a
gcd = gcd(a, b)
print('\n'.join((str(gcd), str(a * b // gcd))), end='')
```

---
