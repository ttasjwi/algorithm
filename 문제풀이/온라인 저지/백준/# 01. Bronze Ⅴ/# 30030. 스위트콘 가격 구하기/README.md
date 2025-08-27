# 문제
- 플랫폼 : 백준
- 번호 : 30030
- 제목 : 스위트콘 가격 구하기
- 난이도 : Bronze 5
- 문제 : <a href="https://www.acmicpc.net/problem/30030" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
import sys

b = int(sys.stdin.readline())
a = (10 * b) // 11
print(a, end= '')
```
- b 는 a 의 1.1 배 이므로, 역으로 a 는 b 의 10/11 배이다.
