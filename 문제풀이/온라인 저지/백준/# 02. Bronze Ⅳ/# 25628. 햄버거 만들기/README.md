# 문제
- 플랫폼 : 백준
- 번호 : 25628
- 제목 : 햄버거 만들기
- 난이도 : Bronze 4
- 만들 수 있는 햄버거의 최대 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/25628" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
a, b = map(int, input().split())
print(b if b * 2 <= a else a // 2)
```
- a가 b*2 이상이면, b의 갯수만큼 햄버거를 만들 수 있다.
- 그렇지 않다면, a를 2로 나눈 몫만큼만 햄버거를 만들 수 있다.

---
