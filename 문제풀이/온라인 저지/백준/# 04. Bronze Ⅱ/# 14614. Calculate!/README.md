# 문제
- 플랫폼 : 백준
- 번호 : 14614
- 제목 : Calculate!
- 난이도 : Bronze 2
- 문제 : <a href="https://www.acmicpc.net/problem/14614" target="_blank">링크</a>

---

# 필요 지식
- 이산수학 - 논리

---

# 풀이
```python
a, b, c = map(int, input().split())

if c % 2:
    a ^= b
print(a, end = '')
```
- `a ^ b ^ b ^ b ...`
- xor 는 결합법칙이 성립된다. (진리표를 그려보자)
  - 뒤의 b ^ b ^ b ^ ... 를 먼저 정리해보면
  - xor 연산이 짝수번 반복되면 이는 0 과 같다.
  - xor 연산이 홀수번 반복되면 이는 b 와 같다.
- 결론
  - c가 짝수일 경우, b 는 소거된다. -> a 를 반환하면 됨
  - c가 홀수일 경우, b 가 하나 남는다. -> a^b 를 계산하면 됨

---
