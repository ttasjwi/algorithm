# 문제
- 플랫폼 : 백준
- 번호 : 16430
- 제목 : 제리와 톰
- 난이도 : Bronze 5
- 문제 : <a href="https://www.acmicpc.net/problem/16430" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
```python
a, b = map(int, input().split())
print(b - a, b)
```
- 1kg 에서 a/b 를 빼면 그 값은 (b-a)/b 이다.
- 그런데 (b-a), b 가 서로소임은 어떻게 증명할까?
  - gcd(a,b) = g 라고 하자
  - g 는 a, b 를 모두 나눌 수 있으므로 a = gs, b = gt 로 표현 가능하다.
  - 그렇다면, (b-a) = g(t -s) 로 표현 가능하다.
  - b-a 는 g로도 나눌 수 있는 수이다. 즉 g 는 b 와 b-a 의 공약수이다.
  - g <= gcd(b-a, b) 로 표현 가능하다.
  - gcd(b-a, b) = h 라고 하자.
  - h 는 b-a, b 를 모두 나눌 수 있으므로 (b-a - b) 를 나눌 수 있는 수이다. 즉 h 는 b 와 a 의 공약수이다.
  - gcd(b-a, b) = h <= gcd(a, b) = g 이다.
  - 즉 g <= gcd(b-a, b) <= g 가 성립하므로 gcd(b-a, b) = g 이다.
  - 그런데 g = 1 이므로(a,b 는 서로소) -> gcd(b-a, b) = 1 , 즉 b-a 와 b는 서로소이다.

---


