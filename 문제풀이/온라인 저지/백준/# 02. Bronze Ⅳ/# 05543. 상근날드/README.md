# 문제
- 플랫폼 : 백준
- 번호 : 05543
- 제목 : 상근날드
- 난이도 : Bronze 4
- 첫째 줄에 가장 싼 세트 메뉴의 가격을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/5543" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
print(min(int(input()) for _ in range(3)) + min(int(input()) for _ in range(2)) - 50)
```
- 단순 사칙연산