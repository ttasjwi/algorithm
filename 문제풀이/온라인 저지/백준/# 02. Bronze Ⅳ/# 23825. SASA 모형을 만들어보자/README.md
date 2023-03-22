# 문제
- 플랫폼 : 백준
- 번호 : 23825
- 제목 : SASA 모형을 만들어보자
- 난이도 : Bronze 4
- 태영이가 만들 수 있는 SASA 모형 개수의 최댓값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/23825" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
n, m = map(int, input().split())
print(min(n//2, m//2))
```
- n과 m을 2로 나눈 몫들 중 작은 값만큼 SASA 모형을 만들 수 있다.

---
